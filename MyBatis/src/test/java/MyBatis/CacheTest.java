package MyBatis;

import Bean.Employee;
import Utils.SqlSessionUtils;
import mappers.CacheMapper;
import mappers.DynamicSQLMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author
 * @description:
 * @create 2022/5/12-15:15
 */
public class CacheTest {
    //测试一级缓存
    @Test
    public void getEmpByIdOne(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee);

        System.out.println();
        Employee employee1 = mapper.getEmpById(1);
        System.out.println(employee1);
    }
    //测试二级缓存
    @Test
    public void getEmpByIdTwo(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config-parameter.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpById(1));
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1));
            sqlSession1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
