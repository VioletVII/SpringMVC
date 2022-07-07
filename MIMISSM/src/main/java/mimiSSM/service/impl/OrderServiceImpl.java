package mimiSSM.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mimiSSM.mapper.OrderMapper;
import mimiSSM.pojo.OrderDetail;
import mimiSSM.pojo.OrderTail;
import mimiSSM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/24-9:00
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    //查询全部
    public List<OrderDetail> selectAll() {
        return orderMapper.selectAll();
    }

    //分页实现
    public PageInfo<OrderDetail> splitPage(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行PageInfo的数据封装
        List<OrderDetail> list = orderMapper.splitPage(pageNum,pageSize);
        PageInfo<OrderDetail> info = new PageInfo<OrderDetail>(list);
        return info;
    }

    public String getOidByOdid(Integer odid) {
        return orderMapper.getByOdid(odid);
    }

    public OrderTail getOrderTailByOid(String oid) {
        return orderMapper.getByOid(oid);
    }
}
