package mimiSSM.service;

import mimiSSM.pojo.ProductType;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/6/11-21:47
 */
public interface ProductTypeService {

    //得到全部商品的类别
    List<ProductType> getAll();
}
