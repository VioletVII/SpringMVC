package MVC.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @description:
 * @create 2022/5/7-19:31
 */
@Controller
public class helloController {
    @RequestMapping(value = "/file")
    public String index(){
        return "file";
    }
}
