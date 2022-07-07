package mimiSSM.service;

import mimiSSM.pojo.Admin;

/**
 * @author
 * @description:
 * @create 2022/5/28-18:42
 */
public interface AdminService {

    //登录验证功能
    Admin login(String name,String pwd);

    //注册功能
    int register(String name,String pwd);
}
