package mimiSSM.service;

import com.github.pagehelper.PageInfo;
import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.OrderTail;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-8:59
 */
public interface OrderService {
    List<OrderDetail> selectAll();

    //分页显示
    PageInfo<OrderDetail> splitPage(int pageNum,int pageSize);

    //查询指定订单号
    String getOidByOdid(Integer odid);

    //查询订单详情
    OrderTail getOrderTailByOid(String oid);
}
