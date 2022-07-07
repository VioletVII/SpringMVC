package mimiSSM.controller;

import com.github.pagehelper.PageInfo;
import mimiSSM.pojo.Users;
import mimiSSM.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-16:08
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    UsersService usersService;
    private static final Integer PAGE_SIZE=5;
    @RequestMapping("/getAllUsers")
    public String getAllUsers(Model model){
        List<Users> list = usersService.getAllUsers();
        model.addAttribute("list",list);
        return "user";
    }

    @RequestMapping("/splitPage")
    public String splitPage(Model model){
        PageInfo<Users> info = usersService.splitPage(1, PAGE_SIZE);
        model.addAttribute("info",info);
        return "user";
    }
}
