package mappers;

import Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/10-19:02
 */
public interface empMapper {

    /*
    查询所有成员
    * */
    List<Employee> getAllEmployee();

    /*
    根据id查询出用户信息和部门信息
    * */
    Employee getEmpAndDept(@Param("id")Integer id);
    /*
    通过分步查询，员工及所对应的部门信息
    分步查询第一步：查询员工信息
    * */
    Employee getEmpAndDeptByStepOne(@Param("id") Integer id);

    /**
     * 通过分步查询，部门对应的所有部门成员信息
     * 分步查询第二步：通过did查询员工对应的部门信息
     */
    List<Employee> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
