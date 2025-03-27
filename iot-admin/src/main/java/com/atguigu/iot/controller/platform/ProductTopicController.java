package com.atguigu.iot.controller.platform;

import com.atguigu.iot.common.result.Result;
import com.atguigu.iot.platform.pojo.ProductTopic;
import com.atguigu.iot.platform.service.ProductTopicService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 产品topic相关操作的控制层
 */
@RestController
@RequestMapping(value = "/platform/productTopic")
public class ProductTopicController {

    @Autowired
    private ProductTopicService productTopicService;

    /**
     * 查询产品的topic
     * @param productId
     * @return
     */
    @GetMapping(value = "/list/{productId}")
    public Result list(@PathVariable(value = "productId") Long productId){
        return Result.ok(productTopicService.list(
                new LambdaQueryWrapper<ProductTopic>()
                        .eq(ProductTopic::getProductId, productId)
                        .eq(ProductTopic::getStatus, "1")));
    }

    /**
     * 保存自定义的topic
     * @param productTopic
     * @return
     */
    @PostMapping
    public Result save(@RequestBody ProductTopic productTopic){
        productTopicService.saveproductTopic(productTopic);
        return Result.ok();
    }

    /**
     * 删除自定义的topic
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") Long id){
        productTopicService.removeById(id);
        return Result.ok();
    }
}
