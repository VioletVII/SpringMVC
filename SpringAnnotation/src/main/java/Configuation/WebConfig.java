package Configuation;

import Interceptor.firstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author
 * @description: springmvc的组件有扫描组件、视图解析器、view controller、default-Servlet-handler、
 * mvc注解驱动、文件上传解析器、异常处理、拦截器
 * @create 2022/5/7-19:15
 */
@Configuration//代替SpringMVC的配置文件
@ComponentScan(basePackages = "MVC.Controller")
@EnableWebMvc//开启MVC的注解驱动
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        //创建Properties设置异常类
        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException","error");
        //设置异常映射
        exceptionResolver.setExceptionMappings(properties);
        //设置共享异常信息的键
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        firstInterceptor firstInterceptor = new firstInterceptor();
        InterceptorRegistration interceptor = registry.addInterceptor(firstInterceptor);
        interceptor.addPathPatterns("/**");//对任何路径进行拦截
        interceptor.excludePathPatterns("/");//除了index路径
    }

    //配置default-Servlet-handler //使用默认的servlet处理静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

    //配置文件上传解析器
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        return multipartResolver;
    }

    //配置view controller
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        ViewControllerRegistration viewController = registry.addViewController("/");
        viewController.setViewName("index");//设置跳转的页面的名字
//        registry.addViewController("/file").setViewName("file");
    }

    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver(){
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context.getServletContext());
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    //生成视图解析器并未解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setOrder(1);
        return viewResolver;
    }
}
