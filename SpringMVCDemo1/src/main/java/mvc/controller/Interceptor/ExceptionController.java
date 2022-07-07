package mvc.controller.Interceptor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author
 * @description:
 * @create 2022/5/7-16:18
 */
@ControllerAdvice//@ControllerAdvice将当前类标识为异常处理的组件
public class ExceptionController {
    //@ExceptionHandler用于设置所标识方法处理的异常
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String testException(Exception exceptionMessage, Model model){
        //exceptionMessag表示当前请求处理中出现的异常对象
        model.addAttribute("exceptionMessage",exceptionMessage);
        return "error";
    }
}
