import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mappers.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Employee;
import pojo.EmployeeExample;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/12-16:59
 */
public class MBGTest {

/**
在查询功能之前使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能
pageNum：当前页的页码
pageSize：每页显示的条数

 在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, intnavigatePages)获取分页相关数据
 list：分页之后的数据
 navigatePages：导航分页的页码数

 PageInfo{pageNum=1, pageSize=10, size=10, startRow=0, endRow=9, total=10, pages=1
 prePage=0, nextPage=0, isFirstPage=true, isLastPage=true, hasPreviousPage=false, hasNextPage=false,
 navigatePages=5, navigateFirstPage=1, navigateLastPage=1, navigatepageNums=[1]}

 pageNum：当前页的页码
 pageSize：每页显示的条数
 size：当前页显示的真实条数
 total：总记录数
 pages：总页数
 prePage：上一页的页码
 nextPage：下一页的页码
 isFirstPage/isLastPage：是否为第一页/最后一页
 hasPreviousPage/hasNextPage：是否存在上一页/下一页
 navigatePages：导航分页的页码数
 navigatepageNums：导航分页的页码，[1,2,3,4,5]
 */
    @Test
    public void Test(){
        try {
            InputStream is = Resources.getResourceAsStream("myBatis_MBG.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //查询所有成员
           /* List<Employee> list = mapper.selectByExample(null);
            list.forEach(employee -> System.out.println(employee));*/
            //查询指定条件
            /*EmployeeExample example = new EmployeeExample();
            example.createCriteria().andEmpNameEqualTo("admin").andAgeEqualTo(12);
            example.or().andDidBetween(1,3);
            List<Employee> list = mapper.selectByExample(example);
            list.forEach(employee -> System.out.println(employee));*/

            //访问第一页，每页四条数据
//            PageHelper.startPage(1,4);
            List<Employee> emps = mapper.selectByExample(null);
            PageInfo<Employee> page = new PageInfo<>(emps,5);

            emps.forEach(System.out::println);
            System.out.println();
            System.out.println(page);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
