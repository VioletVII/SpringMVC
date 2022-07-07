package mimiSSM.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mimiSSM.mapper.ProductInfoMapper;
import mimiSSM.pojo.ProductInfo;
import mimiSSM.pojo.ProductInfoExample;
import mimiSSM.pojo.vo.ProductInfoVo;
import mimiSSM.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/29-18:54
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    //ProductInfo数据访问层的对象
    @Autowired
    ProductInfoMapper productInfoMapper;
    //得到商品的全部信息，不分页
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    //商品的分页功能实现
    public PageInfo splitPage(int pageNum, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(pageNum,pageSize);
        //进行PageInfo的数据封装
        //进行有条件的查询，使用ProductInfoExample封装
        ProductInfoExample example=new ProductInfoExample();
        //将查询到数据，进行降序排序
        //SELECT * FROM product_info ORDER BY p_id DESC;
        example.setOrderByClause("p_id DESC");

        //设置玩排序后，取集合。一定要在取集合之前设置好，PageHelper
        List<ProductInfo> list = productInfoMapper.selectByExample(example);

        //将查询到的集合封装到PageInfo对象中
        PageInfo<ProductInfo> pageInfo=new PageInfo(list);

        return pageInfo;
    }

    //商品的添加功能
    public int save(ProductInfo info) {
        return productInfoMapper.insert(info);
    }

    //商品的修改功能，根据id获得ProductInfo
    public ProductInfo getById(int pid) {
        return productInfoMapper.selectByPrimaryKey(pid);
    }

    //商品的修改功能
    public int update(ProductInfo info) {
        return productInfoMapper.updateByPrimaryKey(info);
    }

    //单个商品的删除功能
    public int delete(int pid) {
        return productInfoMapper.deleteByPrimaryKey(pid);
    }

    //商品的批量删除
    public int deleteBatch(String[] pids) {
        return productInfoMapper.deleteBatch(pids);
    }

    //商品多条件查询
    public List<ProductInfo> selectConditions(ProductInfoVo productInfoVo) {
        return productInfoMapper.selectConditions(productInfoVo);
    }

    //商品多条件查询并且分页
    public PageInfo selectConditionSplit(int pageSize,ProductInfoVo productInfoVo) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(productInfoVo.getPage(),pageSize);
        //商品的多条件查询
        List<ProductInfo> list = productInfoMapper.selectConditions(productInfoVo);
        //将查询到的集合封装到PageInfo对象中
        PageInfo<ProductInfo> pageInfo=new PageInfo(list);
        return pageInfo;
    }


}
