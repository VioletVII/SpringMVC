package mimiSSM.controller;

import mimiSSM.pojo.Admin;
import mimiSSM.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @description:
 * @create 2022/5/28-19:05
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //在所有的界面层，一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;

    //实现登录判断，进行页面的跳转
    @RequestMapping("/login")
    public String login(String name, String pwd, ModelMap modelMap){
        Admin admin = adminService.login(name, pwd);
        if(admin!=null){
            //登录成功
            //对域对象共享数据
            modelMap.addAttribute("admin",admin);
            return "main";
        }else {
            //登录失败
            modelMap.addAttribute("errmsg","登录失败用户名或密码错误");
            return "login";
        }
    }

    //注册管理员
    @RequestMapping("/register")
    public String register(String name, String pwd, Model model){
        int number=-1;
        try {
            number = adminService.register(name, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(number>0){
            model.addAttribute("registErrmsg","注册成功");
            //说明注册成功
            return "login";
        }
        model.addAttribute("registErrmsg","注册失败用户名重复");
        //说明有相同用户名存在的用户
        return "regist";
    }

}
