package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author
 * @description:
 * @create 2022/4/30-15:22
 */
//@RequestMapping标识一个类：设置映射请求的请求路径的初始信息
//@RequestMapping标识一个方法：设置映射请求请求路径的具体信息
//@RequestMapping注解的作用就是将请求和处理请求的控制器方法关联起来，建立映射关系。
//一个请求地址对应一个唯一的@requestMapping
@Controller
@RequestMapping(value = "/test")
public class TestController {
//@RequestMapping注解的value属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求
//请求地址满足任意一个请求映射就可以
//value值不能为空
//method默认所有请求方式都可以
    @RequestMapping(value ={ "/testRequestMapping","/test"},
    method = {RequestMethod.GET,RequestMethod.POST})
    public String toSucces(){
        return "success";
    }

}
