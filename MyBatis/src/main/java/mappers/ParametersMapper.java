package mappers;

import Bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @description: 传入参数的SQL语句
 * @create 2022/5/9-20:02
 */
public interface ParametersMapper {
    /*
     得到全部的信息
     * */
    List<User> getAllUsers();

    /*
     通过用户名获取用户信息
     * */
    User getUserByUsername(String username);

    /*
     登录验证
     * */
    User checkLogin(String username,String password);
    /*
     登录验证
     * */
    User checkLoginByMap(Map<String,Object> map);
    /*
    添加用户
     * */
    int insertUser(User user);

    /*
     登录验证
     * */
    User checkLoginByParams(@Param("username")String username,@Param("password")String password);
}
