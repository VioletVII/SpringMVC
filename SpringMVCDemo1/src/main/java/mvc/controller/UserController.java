package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author
 * @description: 测试restful风格
 * @create 2022/5/4-14:44
 */
@Controller
public class UserController {
    /**
     模拟用户的功能
     /user    get    获取全部用户的信息
     /user/1  get    根据id获取用户信息
     /user    post   添加用户信息
     /user    put    修改用户信息
     /user/1  delete 删除用户细腻
     */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUsers(){
        System.out.println("获取全部用户的信息");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserByID(){
        System.out.println("根据id获取用户信息");
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser( String username, String password){
        System.out.println("添加用户信息");
        System.out.println(username+"  "+password);
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(){
        System.out.println("修改用户信息");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUserByID(){
        System.out.println("删除用户信息");
        return "success";
    }
}
