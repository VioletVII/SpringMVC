package mimiSSM.service.impl;

import mimiSSM.mapper.AdminMapper;
import mimiSSM.pojo.Admin;
import mimiSSM.pojo.AdminExample;
import mimiSSM.service.AdminService;
import mimiSSM.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/28-18:43
 */
@Service
public class AdminServiceImpl implements AdminService {
    //业务逻辑层一定有，数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    public Admin login(String name, String pwd) {
        //1.根据传入的对象到数据库查询
        //1.1如果有条件，则创建AdminExample用于封装条件
        AdminExample example =new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        //1.2 select * from admin where aname='name';
        List<Admin> admins = adminMapper.selectByExample(example);

        if(admins.size()>0){
            //2.如果查询到用户，就进行比较
            Admin admin=admins.get(0);
            /*
             *对传入的密码进行MD5加密，与查询到的用户密码进行比较
             * admin.getPass=c984aed014aec7623a54f0591da07a85fd4b762d
             * 传入的pwd=00000
             */
            String miPwd= MD5Util.getMD5(pwd);
            if (admin.getaPass().equals(miPwd)){
                return admin;
            }
        }
        return null;
    }

    @Autowired
    AdminMapper mapper;
    //注册管理员
    public int register(String name, String pwd) {
        //1.先判断该管理员是否存在，如果存在则不创建
        AdminExample example = new AdminExample();
        example.createCriteria().andANameEqualTo(name);
        List<Admin> admins = adminMapper.selectByExample(example);
        if(admins.size()>0){
            //说明有该相同用户名存在的用户
            return -3;
        }



        //2.如果没有就创建一个新的管理员
        Admin admin = new Admin();
        String miPwd= MD5Util.getMD5(pwd);
        admin.setaName(name);
        admin.setaPass(miPwd);
        return mapper.insert(admin);
    }
}
