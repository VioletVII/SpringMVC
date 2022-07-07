package mimiSSM.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mimiSSM.mapper.UsersMapper;
import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.Users;
import mimiSSM.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-16:03
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    public List<Users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    public PageInfo<Users> splitPage(Integer pageNum, Integer pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行PageInfo的数据封装
        List<Users> list = usersMapper.splitPage(pageNum, pageSize);
        PageInfo<Users> info = new PageInfo<Users>(list);
        return info;
    }
}
