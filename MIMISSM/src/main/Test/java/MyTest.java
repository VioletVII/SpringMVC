import mimiSSM.mapper.OrderMapper;
import mimiSSM.mapper.ProductInfoMapper;
import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.OrderTail;
import mimiSSM.pojo.ProductInfo;
import mimiSSM.pojo.vo.ProductInfoVo;
import mimiSSM.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/28-18:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class MyTest {

    //测试MD5Util的加密算法
    @Test
    public void test(){
        String str = MD5Util.getMD5("000000");
        System.out.println(str);
    }

    @Autowired
    ProductInfoMapper mapper;

    @Test
    public void test1(){
        ProductInfoVo vo=new ProductInfoVo();
//        vo.setLprice(3000.0);
        vo.setHprice(5000.0);
        vo.setTypeid(2);
        List<ProductInfo> list = mapper.selectConditions(vo);
        for(ProductInfo info:list){
            System.out.println(info);
        }
    }

    @Autowired
    OrderMapper orderMapper;
    public void test2(){
        List<OrderDetail> list = orderMapper.selectAll();
        for(OrderDetail info:list){
            System.out.println(info);
        }
    }
    public void test3(){
        OrderTail tail = orderMapper.getByOid("abcd111222333444777888999000wwww");
        System.out.println(tail);
    }
}
