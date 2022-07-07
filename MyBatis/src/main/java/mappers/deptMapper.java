package mappers;

import Bean.Demptment;
import Bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/10-19:02
 */
public interface deptMapper {
    //DeptMapper里的方法
    /**
     * 通过分步查询，员工及所对应的部门信息
     * 分步查询第二步：通过did查询员工对应的部门信息
     */
    Demptment getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 通过分步查询，部门对应的所有部门成员信息
     * 分步查询第一步：通过did查询员工对应的部门信息
     */
    Demptment getDeptAndEmpByStepOne(@Param("did") Integer did);

    /**
     * 通过分步查询，部门对应的所有部门成员信息
     * 通过did查询员工对应的部门信息
     */
    Demptment getDeptAndEmp(@Param("did") Integer did);
}
