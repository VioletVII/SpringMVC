package SelectTest;

import mappers.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/19-15:54
 */
/**
1.导入SpringTest模块
2.@ContextConfiguration指定Spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)//单元测试模块
@ContextConfiguration(locations = "classpath:spring.xml")
public class SelectTest {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired //可以操作批量数据的Sqlsession
    SqlSession sqlSession;
    @Test
    public void selectAll() throws IOException {
//        List<Employee> list = employeeMapper.selectByExample(null);
//        list.forEach(employee -> System.out.println(employee));
        System.out.println(employeeMapper.insertSelective(new Employee(null, "asdf", 12, "asd.qq.com",1)));
    }
}
