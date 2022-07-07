package mimiSSM.service.impl;

import mimiSSM.mapper.ProductTypeMapper;
import mimiSSM.pojo.ProductType;
import mimiSSM.pojo.ProductTypeExample;
import mimiSSM.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/11-21:48
 */

@Service("ProductTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

    //数据访问层的对象
    @Autowired
    ProductTypeMapper productTypeMapper;
    
    //得到全部商品的类别
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
