package mimiSSM.service;

import com.github.pagehelper.PageInfo;
import mimiSSM.pojo.Users;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-16:03
 */
public interface UsersService {
    List<Users> getAllUsers();

    PageInfo<Users> splitPage(Integer pageNum, Integer pageSize);
}
