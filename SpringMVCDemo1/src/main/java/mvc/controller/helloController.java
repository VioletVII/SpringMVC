package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author
 * @description:
 * @create 2022/4/30-12:23
 */
// @RequestMapping注解：处理请求和控制器方法之间的映射关系
// @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
// localhost:8080/springMVC/
@Controller
public class helloController {

//    @RequestMapping(value = "/")
//    public String index(){
//      return "index";
//    }

    @RequestMapping(value = "/target")
    public String toTarget(){
        return "target";
    }

    @RequestMapping(value = "/parms")
    public String toTest_parms(){
        return "test_parms";
    }
    @RequestMapping(value = "/scope")
    public String toTestScope(){
        return "test_scope";
    }

    @RequestMapping(value = "/test_view")
    public String toTest_view(){
        return "test_view";
    }

    @RequestMapping(value = "/test_user")
    public String toTest_user(){
        return "test_user";
    }
    @RequestMapping(value = "/test_Employee")
    public String toTest_Employee(){
        return "Test_Employee";
    }

    @RequestMapping(value = "/httpMessage")
    public String testHttpMessageConverter(){
        return "HttpMessageConverter";
    }
}
