package mappers;

import Bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @description:
 * @create 2022/5/10-14:34
 */
public interface SelectMapper {
    /**
     根据用户id查询用户信息
     */
    User getUserById(@Param("id") int id);
    /**
     获取用户数量
     */
    int getCount();
    /**
     根据用户id查询用户信息
     */
    List<User> getUserByIdToList(@Param("id") int id);
    /**
     根据用户id查询用户信息
     */
    Map<String,Object> getUserByIdToMap(@Param("id") int id);
    /**
     查询所有用户信息
     */
    List<User> getAllUsersTolist();
    /**
     查询所有用户信息
     */
    List<Map<String,Object>> getAllUsersToListInMap();
    /**
     查询所有用户信息
     以id作为map的键，以{password=admin, id=1, email=admin@qq.com, username=admin}为值
     */
    @MapKey("id")
    Map<String,Object> getAllUsersToMapKey();

    /**
     查询用户名中包含a的所有用户信息
     */
    List<User> getUserByByLikeUsername(@Param("username")String username);
    /**
     批量的删除
     */
    int deleteUserMore(@Param("ids")String ids);
    /**
     动态获取表名,查询所有用户信息
     */
    List<User> getAllUsersTolistFromTable(@Param("table")String table);
    /**
     添加用户，或得自增的主键
     */
    int insertUserGetId(User user);
}
