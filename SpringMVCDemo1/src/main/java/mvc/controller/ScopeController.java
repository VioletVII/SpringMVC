package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author
 * @description: 测试域对象共享数据
 * @create 2022/5/2-19:10
 */
@Controller
public class ScopeController {
//使用ServletAPI向request域对象共享数据
    @RequestMapping(value = "/testServletAPIByRequest")
    public String testServletAPIByRequest(HttpServletRequest request){
        request.setAttribute("testRequestScope","ServletAPI");
        return "success_scope";
    }
//2、使用ModelAndView向request域对象共享数据
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav=new ModelAndView();
        //设置共享数据
        mav.addObject("testRequestScope","hellp,testModelAndView");
        //设置视图，实现页面跳转,传入页面的名称
        mav.setViewName("success_scope");
        return mav;
    }
//3、使用Model向request域对象共享数据
    @RequestMapping(value = "/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello,Model");
        return "success_scope";
    }
//    4、使用map向request域对象共享数据
    @RequestMapping(value = "/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","hello,Map");
        return "success_scope";
    }
//    5、使用ModelMap向request域对象共享数据
    @RequestMapping(value = "/TestModelMap")
    public String TestModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,modelMap");
        return "success_scope";
    }
//  7、向session域共享数据
    @RequestMapping(value = "/TestSession")
    public String TestSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session");
        return "success_scope";
    }
//    向application域共享数据
    @RequestMapping(value = "/TestApplication")
    public String TestApplication(HttpSession session){
        ServletContext context = session.getServletContext();
        context.setAttribute("TestApplicationScope","hello,TestApplication");
        return "success_scope";
    }
}
