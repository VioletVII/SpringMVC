package mappers;

import Bean.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author
 * @description:
 * @create 2022/5/12-15:08
 */
public interface CacheMapper {

    /*
     测试一级缓存
     * */
    Employee getEmpById(@Param("id")Integer id);
}
