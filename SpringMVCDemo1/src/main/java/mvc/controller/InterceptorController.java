package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @description:
 * @create 2022/5/7-14:58
 */
@Controller
public class InterceptorController {

    @RequestMapping("/**/TestInterceptor")
    public String TestInterceptor(){
        return "success";
    }

    @RequestMapping("/TestException")
    public String TestException(){
        System.out.println(10/0);
        return "success";
    }
}
