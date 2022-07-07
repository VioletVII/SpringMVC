package MyBatis;

import Bean.User;
import Utils.SqlSessionUtils;
import mappers.ParametersMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @description:
 * @create 2022/5/9-20:10
 */
public class ParameterTest {
    @Test
    public void getAllUsers(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParametersMapper mapper = sqlSession.getMapper(ParametersMapper.class);
        List<User> list = mapper.getAllUsers();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParametersMapper mapper = sqlSession.getMapper(ParametersMapper.class);
        System.out.println(mapper.getUserByUsername("admin"));
    }
    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParametersMapper mapper = sqlSession.getMapper(ParametersMapper.class);
        System.out.println(mapper.checkLogin("admin","admin"));
    }
    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParametersMapper mapper = sqlSession.getMapper(ParametersMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","admin");
        System.out.println(mapper.checkLoginByMap(map));
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParametersMapper mapper = sqlSession.getMapper(ParametersMapper.class);
        System.out.println(mapper.insertUser(new User(null,"李四","李四1234","李四@qq.com")));
    }

    @Test
    public void checkLoginByParams(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParametersMapper mapper = sqlSession.getMapper(ParametersMapper.class);
        User user = mapper.checkLoginByParams("admin", "admin");
        System.out.println(user);
    }
}
