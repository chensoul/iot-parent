package com.atguigu.iot.platform.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.atguigu.iot.platform.mapper.DeviceInfoMapper;
import com.atguigu.iot.platform.mapper.ProductInfoMapper;
import com.atguigu.iot.platform.mapper.ProductTopicMapper;
import com.atguigu.iot.platform.mapper.TopicTemplateMapper;
import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.pojo.ProductInfo;
import com.atguigu.iot.platform.pojo.ProductTopic;
import com.atguigu.iot.platform.pojo.TopicTemplate;
import com.atguigu.iot.platform.query.ProductInfoQuery;
import com.atguigu.iot.platform.service.ProductInfoService;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/***
 * 产品相关操作的接口类的实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductInfoServiceImpl
        extends ServiceImpl<ProductInfoMapper, ProductInfo>
        implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 分页条件查询产品信息
     *
     * @param productInfoQuery
     * @return
     */
    @Override
    public Page<ProductInfo> list(ProductInfoQuery productInfoQuery) {
        return productInfoMapper.pageProductInfo(
                new Page<ProductInfo>(productInfoQuery.getPageNum(),
                        productInfoQuery.getPageSize()),
                productInfoQuery);
    }

    @Autowired
    private TopicTemplateMapper topicTemplateMapper;

    @Autowired
    private ProductTopicMapper productTopicMapper;
    /**
     * 新增产品
     *
     * @param productInfo
     */
    @Override
    public void saveProduct(ProductInfo productInfo) {
        //补全数据
        productInfo.setProductKey(RandomUtil.randomString(10));
        productInfo.setStatus("1");
        productInfo.setCreateTime(new Date());
        productInfo.setCreateBy(StpUtil.getLoginIdAsString());
        //新增产品
        if(!save(productInfo)){
            throw new GuiguException(201, "新增产品失败!");
        }
        //查询template_topic表的信息
        List<TopicTemplate> topicTemplates =
                topicTemplateMapper.selectList(
                        new LambdaQueryWrapper<TopicTemplate>()
                                .eq(TopicTemplate::getStatus, "1"));
        //初始化product_topic表的数据
        topicTemplates.stream().forEach(topicTemplate -> {
            //初始化
            ProductTopic productTopic = new ProductTopic();
            //产品id
            productTopic.setProductId(productInfo.getId());
            //topic类型
            productTopic.setTopicType(topicTemplate.getTopicType());
            //topic的内容
            productTopic.setTopic(topicTemplate.getTopic()
                    .replace("${productKey}", productInfo.getProductKey()));
            //组名
            productTopic.setGroupName(topicTemplate.getGroupName());
            //操作类型
            productTopic.setOptionType(topicTemplate.getOptionType());
            //状态
            productTopic.setStatus("1");
            //保存产品的topic数据
            int insert = productTopicMapper.insert(productTopic);
            if(insert <= 0){
                throw new GuiguException(201, "保存产品失败,因为产品topic表的初始化失败!");
            }
        });
    }


    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    /**
     * 删除产品
     *
     * @param ids
     */
    @Override
    public void deleteProduct(List<Long> ids) {
        //判断产品是否包含绑定的设备
        Long count = deviceInfoMapper.selectCount(
                new LambdaQueryWrapper<DeviceInfo>()
                        .in(DeviceInfo::getProductId, ids));
        if(count > 0){
            throw new GuiguException(201, "产品包含绑定的设备无法被删除!");
        }
        //删除产品
        if(!removeBatchByIds(ids)){
            throw new GuiguException(201, "删除产品失败!");
        }
        //删除产品的topic数据
        productTopicMapper.delete(
                new LambdaQueryWrapper<ProductTopic>()
                        .in(ProductTopic::getProductId, ids));
    }

    /**
     * 查询产品的详细信息
     *
     * @param id
     * @return
     */
    @Override
    public ProductInfo getOne(Long id) {
        //查询产品的数据
        ProductInfo productInfo = getById(id);
        //查询设备的数量
        Long count = deviceInfoMapper.selectCount(
                new LambdaQueryWrapper<DeviceInfo>()
                        .eq(DeviceInfo::getProductId, id));
        productInfo.setDeviceNum(count);
        //返回
        return productInfo;
    }
}
