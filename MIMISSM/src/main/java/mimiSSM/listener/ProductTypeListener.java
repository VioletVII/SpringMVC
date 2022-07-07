package mimiSSM.listener;

import mimiSSM.pojo.ProductType;
import mimiSSM.service.ProductTypeService;
import mimiSSM.service.impl.ProductTypeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/11-21:59
 */
/*
 因为商品的类型，需要在项目启动时，进行获取。保证了在新增商品，修改商品时的下拉列表的
 类别的显示
 **/
@WebListener
public class ProductTypeListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //手动从Spring容器中取出ProductTypeServiceImpl的对象
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductTypeService service= (ProductTypeService) context.getBean("ProductTypeService", ProductTypeService.class);
        List<ProductType> typeList = service.getAll();
        //放入全局应用作用域中，共新增页面，修改页面，前台的查询功能提供全部商品类别集合
        servletContextEvent.getServletContext().setAttribute("typeList",typeList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
