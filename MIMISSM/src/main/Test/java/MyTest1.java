import mimiSSM.mapper.OrderMapper;
import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.OrderTail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/23-23:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class MyTest1 {
    @Autowired
    OrderMapper orderMapper;
    public void test3(){
        OrderTail tail = orderMapper.getByOid("abcd111222333444777888999000wwww");
        System.out.println(tail);
    }
}
