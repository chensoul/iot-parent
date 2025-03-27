package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.query.ProductInfoQuery;
import com.atguigu.iot.platform.service.ProductInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * 产品相关的控制层
 */
@RestController
@RequestMapping(value = "/platform/productInfo")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 分页条件查询产品信息
     * @param productInfoQuery
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(ProductInfoQuery productInfoQuery){
        return Result.ok(productInfoService.list(productInfoQuery));
    }

    /**
     * 新增产品
     * @param productInfo
     * @return
     */
    @PostMapping
    public Result save(@RequestBody ProductInfo productInfo){
        productInfoService.saveProduct(productInfo);
        return Result.ok();
    }

    /**
     * 删除产品
     * @param ids
     * @return
     */
    @DeleteMapping(value = "/{ids}")
    public Result deleteProduct(@PathVariable(value = "ids") List<Long> ids){
        productInfoService.deleteProduct(ids);
        return Result.ok();
    }

    /**
     * 查询产品的详细信息
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Result getOne(@PathVariable(value = "id") Long id){
        return Result.ok(productInfoService.getOne(id));
    }

    /**
     * 查询的所有的产品列表
     * @return
     */
    @GetMapping(value = "/listAll")
    public Result listAll(){
        return Result.ok(productInfoService.list(
                new LambdaQueryWrapper<ProductInfo>()
                        .eq(ProductInfo::getStatus, "1")));
    }
}
