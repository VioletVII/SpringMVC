package mimiSSM.controller;

import com.github.pagehelper.PageInfo;
import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.OrderTail;
import mimiSSM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-9:01
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    private static final Integer PAGE_SIZE=5;
    //显示全部
    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        List<OrderDetail> list = orderService.selectAll();
        model.addAttribute("list",list);
        return "order";
    }

    //分页显示,分页显示不完全，因为不能使用分页插件
    @RequestMapping("/splitPage")
    public String splitPage(Model model){
        PageInfo<OrderDetail> info = orderService.splitPage(1, PAGE_SIZE);
        model.addAttribute("info",info);
        return "order";
    }

    //跳转信息界面
    @RequestMapping("/toOrderTail")
    public String toOrderTail(Integer odid,Model model){
        String oid = orderService.getOidByOdid(odid);
        OrderTail tail = orderService.getOrderTailByOid(oid);
        model.addAttribute("tail",tail);
        return "orderTail";
    }

}
