package mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @description: 测试解析jsp页面
 * @create 2022/5/4-10:49
 */
public class JSPController {

    @RequestMapping(value = "/successJsp")
    public String successJSP(){
        return "successJSP";
    }
}
