package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @description: 测试view视图
 * @create 2022/5/3-19:15
 */
@Controller
public class ViewController {

    //没有任何前缀，创建的视图为ThymeleafView
    @RequestMapping(value = "/TestThymeleafView")
    public String toTestThymeleafView(){
        return "success";
    }
    //视图名称以"forward:"为前缀时，创建InternalResourceView视图，此时的视图为转发视图
    //用于转发到请求，用的不多
    //地址栏会显示TestInternalResourceView
    @RequestMapping(value = "/TestInternalResourceView")
    public String toTestInternalResourceViewByForword(){
        return "forward:/TestThymeleafView";
    }
//    当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，此时视图为重定向视图
// 地址栏会显示TestThymeleafView
    @RequestMapping(value = "/TestRedirectView")
    public String toTestRedirectView(){
        return "redirect:/TestThymeleafView";
    }
}
