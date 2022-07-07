package mappers;

import Bean.User;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/9-14:19
 */
public interface UserMapper {
    /**
     添加用户
     */
    int insertUser();
    /**
     修改用户信息
     */
    int UpdateUser();
    /**
    删除用户信息
     */
    int DeleteUser();
    /**
     根据id获取用户信息
     */
    User getUserById();
    /**
     获取用户全部信息
     */
    List<User> getAllUser();
}
