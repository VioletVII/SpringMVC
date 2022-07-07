package MyBatis;

import Bean.Employee;
import Utils.SqlSessionUtils;
import mappers.DynamicSQLMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/11-19:40
 */
public class DynamicSQLTest {
    @Test
    public void getEmployeeByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> list = mapper.getEmployeeByCondition(new Employee(0, "admin",0, ""));
        System.out.println(list);
    }
    @Test
    public void getEmployeeByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Employee> list = mapper.getEmployeeByChoose(new Employee(0, "",0, "123@123.com"));
        System.out.println(list);
    }
    @Test
    public void deleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{4, 5});
        System.out.println(i);
    }
    @Test
    public void insertMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Employee a1 = new Employee(0, "a1", 13, "123@123qq.com");
        Employee a2 = new Employee(0, "a2", 13, "123@123qq.com");
        Employee a3 = new Employee(0, "a3", 13, "123@123qq.com");
        List<Employee> list = Arrays.asList(a1, a2, a3);
        int i = mapper.insertMoreByArray(list);
        System.out.println(i);
    }
}
