package MyBatis;

import Bean.User;
import Utils.SqlSessionUtils;
import mappers.SelectMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author
 * @description:
 * @create 2022/5/10-14:41
 */
public class SelectTest {
    @Test
    public void getUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(1));
    }
    @Test
    public void getCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }
    @Test
    public void getUserByIdToList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToList(1));
    }
    @Test
    public void getUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(1));
        //{password=admin, id=1, email=admin@qq.com, username=admin}
    }
    @Test
    public void getAllUsersTolist(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUsersTolist());
    }
    @Test
    public void getAllUsersToListInMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUsersToListInMap());
    }
    @Test
    public void getAllUsersToMapKey(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUsersToMapKey());
    }
    @Test
    public void getUserByByLikeUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByByLikeUsername("a"));
    }
    @Test
    public void deleteUserMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.deleteUserMore("7,8,9"));
    }
    @Test
    public void getAllUsersTolistFromTable(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUsersTolistFromTable("t_user"));
    }
    @Test
    public void insertUserGetId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user=new User(null,"王五8954","wangwu","123@qq.com");
        mapper.insertUserGetId(user);
        System.out.println(user);
        //User{id=20, username='王五8954', password='wangwu', email='123@qq.com'}
    }
}
