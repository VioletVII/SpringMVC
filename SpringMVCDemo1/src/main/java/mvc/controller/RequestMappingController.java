package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author
 * @description: 测试RequestMapping的注解
 * @create 2022/5/1-19:19
 */
@Controller
public class RequestMappingController {
    //RequestMapping的派生注解
    //处理get请求的映射–>@GetMapping
    @GetMapping(value = "/toGetMapping")
    public String toGetMapping(){
        return "success";
    }

    @RequestMapping(value = "/Testput",method ={RequestMethod.PUT})
    public String Testput(){
        return "success";
    }

    //请求方式不对405 请求参数不对400 请求头不对404
    //params属性和handler属性必须数组里面的值全部满足，才能转发
    @RequestMapping(value = "/TestParamsAndHandler",
            params ={"username","password"},
            headers = "Host: localhost:8080")
    public String TestParamsAndHandler(){
        return "success";
    }

//？：表示任意的单个字符
//*：表示任意的0个或多个字符
//**：表示任意的一层或多层目录
//注意：在使用**时，只能使用/**/xxx的方式
//    @RequestMapping(value = "/a?a/TestAnt")
    @RequestMapping(value = "/a*a/TestAnt")
//@RequestMapping(value = "/**/TestAnt")
    public String TestAnt(){
        return "success";
    }

    //@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在通过@PathVariable注解，
// 将占位符所表示的数据赋值给控制器方法的形参
    @RequestMapping(value = "/testRest/{id}/{username}")
    public String testRest(@PathVariable("id")Integer id, @PathVariable("username")String username){
        System.out.println("id: "+id+",username: "+username);
        return "success";
    }
}
