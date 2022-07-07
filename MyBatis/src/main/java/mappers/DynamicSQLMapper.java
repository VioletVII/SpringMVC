package mappers;

import Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/11-19:35
 */
public interface DynamicSQLMapper {
    /*
     通过多条件动态查询用户信息
     * */
    List<Employee> getEmployeeByCondition(Employee employee);

    /*
     通过多条件动态查询用户信息,Choose When,otherwise
     * */
    List<Employee> getEmployeeByChoose(Employee employee);

    /*
     批量删除
     * */
    int deleteMoreByArray(@Param("ids") Integer[] ids);

    /*
     批量添加
     * */
    int insertMoreByArray(@Param("emps") List<Employee> employees);
}
