package mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Deptment;
import pojo.DeptmentExample;

public interface DeptmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int countByExample(DeptmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int deleteByExample(DeptmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int deleteByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int insert(Deptment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int insertSelective(Deptment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    List<Deptment> selectByExample(DeptmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    Deptment selectByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int updateByExampleSelective(@Param("record") Deptment record, @Param("example") DeptmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int updateByExample(@Param("record") Deptment record, @Param("example") DeptmentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int updateByPrimaryKeySelective(Deptment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dept
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    int updateByPrimaryKey(Deptment record);
}