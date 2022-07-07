package mimiSSM.mapper;

import com.github.pagehelper.PageInfo;
import mimiSSM.pojo.Users;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-16:04
 */
public interface UsersMapper {
    List<Users> getAllUsers();

    List<Users> splitPage(Integer pageNum, Integer pageSize);
}
