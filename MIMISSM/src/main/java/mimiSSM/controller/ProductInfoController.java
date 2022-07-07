package mimiSSM.controller;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.log.Log;
import javafx.scene.control.Alert;
import mimiSSM.pojo.ProductInfo;
import mimiSSM.pojo.vo.ProductInfoVo;
import mimiSSM.service.ProductInfoService;
import mimiSSM.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author
 * @description:
 * @create 2022/5/29-18:58
 */
@Controller
@RequestMapping("/prod")
public class ProductInfoController {
    //固定每页的数量
    private static final  int PAGE_SIZE=5;
    //图片异步上传的名字
    String saveFileName="";

    //业务逻辑层的对象
    @Autowired
    ProductInfoService productInfoService;

    //显示所有商品信息,不分页
    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<ProductInfo> list = productInfoService.getAll();
        model.addAttribute("list",list);

        return "product";
    }

    //显示第一页的分页的数据
    @RequestMapping("/split")
    public String split(Model model,HttpServletRequest request){
        PageInfo info=null;
        //如果有查询
        ProductInfoVo vo = (ProductInfoVo) request.getSession().getAttribute("productVo");
        if(vo!=null){
            info=productInfoService.selectConditionSplit(PAGE_SIZE,vo);
            //移除productVo 避免后续出错
            request.getSession().removeAttribute("productVo");
        }else {
            //得到第一页的数据
            info = productInfoService.splitPage(1, PAGE_SIZE);
        }
        model.addAttribute("info",info);
        return "product";
    }

    //ajax分页翻页处理
    @ResponseBody
    @RequestMapping("/ajaxSplit")
    public void ajaxSplit(ProductInfoVo vo, HttpSession session){
        PageInfo info = productInfoService.selectConditionSplit(PAGE_SIZE,vo);
        session.setAttribute("info",info);
    }

    //商品多条件查询
    @ResponseBody
    @RequestMapping("/condition")
    public void condition(ProductInfoVo infoVo,HttpSession session){
        List<ProductInfo> list = productInfoService.selectConditions(infoVo);
        session.setAttribute("list",list);
    }

    //ajax异步上传文件
    @ResponseBody
    @RequestMapping("/ajaxImg")
    //<input type="file" id="pimage" name="pimage" onchange="fileChange()" >
    public Object ajaxImg(MultipartFile pimage, HttpServletRequest request){
        //1.提取生成文件的UUID+上传文件的后缀.jpg .png
        saveFileName= FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
        //2.得到项目中图片存储的路径 C:\workspace_idea\SpringMVC\MIMISSM\image_big
        String savePath=request.getServletContext().getRealPath("/image_big");
        //3.转存 C:\workspace_idea\SpringMVC\MIMISSM\image_big\sdad.jpg
        try {
            pimage.transferTo(new File(savePath+File.separator+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回客服端啊JSON对象，封装图片的路径，为了在页面实现立即显示
        JSONObject object=new JSONObject();
        object.put("imgurl",saveFileName);

        return object.toString();
    }

    //新增商品的表单提交，并跳转到显示界面
    @RequestMapping("/save")
    public String save(ProductInfo info,Model model){
        info.setpImage(saveFileName);
        info.setpDate(new Date());

        int num=-1;
        try {
            num=productInfoService.save(info);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //添加成功或失败，消息提醒
        if(num>0){
            model.addAttribute("msg","添加成功!");
        }else {
            model.addAttribute("msg","添加失败!");
        }

        //保存后，清空saveFileName的内容，方便后面的添加或修改。修改可以根据saveFileName是否有值来判断，图片是否被修改过
        saveFileName="";

        //增加成功后应该重新访问数据库，所以跳转到分页显示的action上
        return "forward:/prod/split.action";
    }

    //商品的修改功能，根据id获得ProductInfo,然后向页面显示数据
    @RequestMapping("/one")
    public String one(int pid,ProductInfoVo vo,Model model,HttpSession session){
        ProductInfo info = productInfoService.getById(pid);
        model.addAttribute("prod",info);
        //把查询条件传递到分页去
        session.setAttribute("productVo",vo);
        return "update";
    }

    //商品的修改功能
    @RequestMapping("/update")
    public String update(ProductInfo info,Model model){

        //因为Ajax的异步上传图片，如果有上传过，
        // 则saveFileName里有上传的图片的名称。
        // 如果没有使用Ajax异步上传过图片，则saveFileName=“”
        // 则实体类info使用隐藏表单提交上来的pImage原始图片的名称
        if(!saveFileName.equals("")){
            //Ajax的异步上传图片
            info.setpImage(saveFileName);
        }

        //保存修改过后的数据到数据库中
        int num=-1;
        try {
            num = productInfoService.update(info);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(num>0){
            //更新成功
            model.addAttribute("msg","修改成功");
        }else {
            //更新失败
            model.addAttribute("msg","修改失败");
        }
        //保存后，清空saveFileName的内容，方便后面的添加或修改。修改可以根据saveFileName是否有值来判断，图片是否被修改过
        saveFileName="";
        return "forward:/prod/split.action";
    }

    //单个商品的删除功能
    @RequestMapping("/delete")
    public String delete(int pid,ProductInfoVo vo,HttpServletRequest request){
        int num=-1;

        try {
            num = productInfoService.delete(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //完成删除后的判断
        if(num>0){
            request.setAttribute("msg","删除成功！");
        }else {
            request.setAttribute("msg","删除失败！");
        }
        request.getSession().setAttribute("productVo",vo);
        //删除结束后的分页显示
        return "forward:/prod/deleteAjaxSplit.action";
    }

    //删除结束后的分页显示
    @ResponseBody
    @RequestMapping(value = "/deleteAjaxSplit",produces = "text/html;charset=UTF-8")
    public Object deleteAjaxSplit(HttpServletRequest request){
        PageInfo info=null;
        //如果有多条件查询
        ProductInfoVo vo = (ProductInfoVo) request.getSession().getAttribute("productVo");
        if(vo!=null){
            info=productInfoService.selectConditionSplit(PAGE_SIZE,vo);
            request.getSession().removeAttribute("productVo");
        }else {
            //得到第一页的数据
            info = productInfoService.splitPage(1, PAGE_SIZE);
        }
        request.getSession().setAttribute("info",info);
        return request.getAttribute("msg");
    }

    //商品的批量删除
    @RequestMapping("/deleteBatch")
    public String deleteBatch(String pids,ProductInfoVo vo,Model model,HttpServletRequest request){
        //先将pids根据,进行分割成字符串数组,形成商品id的数组
        String[] ids = pids.split(",");

        int num=-1;

        try {
            num=productInfoService.deleteBatch(ids);
            if(num>0){
                model.addAttribute("msg","批量删除成功");
            }else {
                model.addAttribute("msg","批量删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg","商品不可删除");
        }

        request.getSession().setAttribute("productVo",vo);
        return "forward:/prod/deleteAjaxSplit.action";
    }

}
