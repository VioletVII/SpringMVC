package mvc.controller;

import mvc.controller.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author
 * @description: 测试参数注解
 * @create 2022/5/1-19:36
 */
@Controller
public class ParmsController {
/*
 方式1：通过ServletAPI获取请求参数
 将HttpServletRequest作为控制器方法的形参，
 此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
 * */
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+" password:"+password);
        return "success";
    }
/*
方式2 通过控制器方法的形参获取请求参数
在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，
在DispatcherServlet中就会将请求参数赋值给同名的形参
* */
    @RequestMapping("/testParms")
    public String testParms(String username,String password,String[] hobby){
        /*
若请求所传输的请求参数中有多个同名的请求参数，此时可以在控制器方法的形参中设置字符串数组或者字符串类型的形参接收此请求参数
若使用字符串数组类型的形参，此参数的数组中包含了每一个数据
若使用字符串类型的形参，此参数的值为每个数据中间使用逗号拼接的结果 例如hobby的请求参数 a,b,c
         * */
        System.out.println("username:"+username+" password:"+password+" hobby"+ Arrays.toString(hobby));
        //username:username password:password hobby[a, b, c]
        return "success";
    }
/*
@RequestParam是将请求参数和控制器方法的形参创建映射关系
@RequestParam注解一共有三个属性：
value：指定为形参赋值的请求参数的参数名
required：设置是否必须传输此请求参数，默认值为true
若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置defaultValue属性，则页面报错400：Required String parameter ‘xxx’ is not present；若设置为false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为null
defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值为""时，则使用默认值为形参赋值
* */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "user_name",defaultValue = "hhhh") String username,
            String password,
            @RequestHeader(value = "Host",defaultValue = "hhhh")String host,
            String[] hobby){
        System.out.println("username:"+username+" password:"+password+" hobby"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        //username:username password:password hobby[a, b, c]
        return "success";
    }

//    可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，
//    那么请求参数就会为此属性赋值
    @RequestMapping(value = "/testBean")
    public String testBean(User user){
        System.out.println(user);
//        User{id=null, username='asd123', password='adasd', sex='???', age=12, email='2214223266@qq.com'}
        return "success";
    }
}
