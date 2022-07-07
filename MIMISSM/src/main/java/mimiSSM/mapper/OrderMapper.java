package mimiSSM.mapper;

import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.OrderTail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/23-22:14
 */
public interface OrderMapper {
    //查询所有的订单
    List<OrderDetail> selectAll();

    //分页显示订单
    List<OrderDetail> splitPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    //查询指定订单的详细信息
    OrderTail getByOid(String oid);

    //根据指定的订单id，查询订单号
    String getByOdid(Integer odid);
}
