package com.atguigu.iot.platform.mapper;

import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.query.ProductInfoQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 * 产品表的mapper映射
 */
@Mapper
public interface ProductInfoMapper  extends BaseMapper<ProductInfo> {

    /**
     * 分页条件查询产品信息
     * @param page
     * @param productInfoQuery
     * @return
     */
    Page<ProductInfo> pageProductInfo(Page<ProductInfo> page,
                                      @Param("vo") ProductInfoQuery productInfoQuery);
}
