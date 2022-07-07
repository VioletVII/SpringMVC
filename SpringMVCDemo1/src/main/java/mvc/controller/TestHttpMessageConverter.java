package mvc.controller;

import mvc.controller.Bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @description: 测试HttpMessageConverter，报文信息转换器，将请求报文转换为Java对象，或将Java对象转换为响应报文
 *
 * HttpMessageConverter提供了两个注解和两个类型：@RequestBody，@ResponseBody，RequestEntity，ResponseEntity
 * @create 2022/5/6-15:01
 */
@Controller
public class TestHttpMessageConverter {

    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        //获取请求体
        System.out.println(requestBody);
        //requestBody:username=admin&password=123456
        return "success";
    }
    @RequestMapping(value = "/testRequestEntity")
    public String testRequestEntity( RequestEntity<String> requestEntity){
        //获取整个请求，包括请求头和请求体
        System.out.println("请求头"+requestEntity.getHeaders());//请求头
        System.out.println("请求体"+requestEntity.getBody());//请求体
        return "success";
    }
    @RequestMapping(value = "/TestResponse")
    public void TestResponse(HttpServletResponse response) throws IOException {
        //原始响应浏览器的方式
        response.getWriter().print("hello,response");
    }
    @RequestMapping(value = "/TestResponseBody")
    @ResponseBody
    public String TestResponseBody(){
        //@ResponseBody用于标识一个控制器方法，
        // 可以将该方法的返回值直接作为响应报文的响应体响应到浏览器,不在是跳转页面
        return "hello,TestResponseBody";
    }
    @RequestMapping(value = "/TestResponseBodyUser")
    @ResponseBody
    public User TestResponseBodyUser(){
        //@ResponseBody用于标识一个控制器方法，
        // 可以将该方法的返回值直接作为响应报文的响应体响应到浏览器,不在是跳转页面
        //返回一个user对象
        return new User(1,"admin","admin","女",18,"2233.@QQ.com");
    }
    @RequestMapping(value = "/testAjax")
    @ResponseBody
    public String testAjax(String username,String passsword){
        System.out.println("username:"+username+",password:"+passsword);
        return "hello,ajax";
    }
}

