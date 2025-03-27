package com.atguigu.iot.platform.service;

import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.query.ProductInfoQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/***
 * 产品相关操作的接口类
 */
public interface ProductInfoService extends IService<ProductInfo> {

    /**
     * 分页条件查询产品信息
     * @param productInfoQuery
     * @return
     */
    Page<ProductInfo> list(ProductInfoQuery productInfoQuery);

    /**
     * 新增产品
     * @param productInfo
     */
    void saveProduct(ProductInfo productInfo);

    /**
     * 删除产品
     * @param ids
     */
    void deleteProduct(List<Long> ids);

    /**
     * 查询产品的详细信息
     * @param id
     * @return
     */
    ProductInfo getOne(Long id);
}
