package MyBatis;

import Bean.Demptment;
import Bean.Employee;
import Utils.SqlSessionUtils;
import mappers.deptMapper;
import mappers.empMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/10-19:15
 */
public class EmployeeTest {
    @Test
    public void getAllEmployee(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        List<Employee> list = mapper.getAllEmployee();
        list.forEach(employee -> System.out.println(employee));
    }
    @Test
    public void getEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        Employee empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
    }
    @Test
    public void getEmpAndDeptByStepOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        empMapper mapper = sqlSession.getMapper(empMapper.class);
        Employee empAndDept = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(empAndDept.getEmpName());
    }
    @Test
    public void getDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        deptMapper mapper = sqlSession.getMapper(deptMapper.class);
        Demptment emp = mapper.getDeptAndEmp(1);
        System.out.println(emp);
    }
    @Test
    public void getDeptAndEmpByStepOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        deptMapper mapper = sqlSession.getMapper(deptMapper.class);
        Demptment emp = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(emp.getDepName()+"**************************");
        System.out.println(emp.getEmps());
    }
}
