package mimiSSM.service;

import com.github.pagehelper.PageInfo;
import mimiSSM.pojo.ProductInfo;
import mimiSSM.pojo.vo.ProductInfoVo;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/29-18:53
 */
public interface ProductInfoService {
    //得到全部商品的信息，不分页
    List<ProductInfo> getAll();

    //商品的分页功能的实现
    PageInfo splitPage(int pageNum,int pageSize);

    //商品的添加功能
    int save(ProductInfo info);

    //商品的修改功能，根据id获得ProductInfo
    ProductInfo getById(int pid);

    //商品的修改功能
    int update(ProductInfo info);

    //单个商品的删除功能
    int delete(int pid);

    //商品的批量删除
    int deleteBatch(String[] pids);

    //商品多条件查询
    List<ProductInfo> selectConditions(ProductInfoVo productInfoVo);

    //商品多条件查询分页
    PageInfo selectConditionSplit(int pageSize,ProductInfoVo productInfoVo);
}