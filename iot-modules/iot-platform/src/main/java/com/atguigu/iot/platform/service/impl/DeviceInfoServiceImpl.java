package com.atguigu.iot.platform.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.RandomUtil;
import com.atguigu.iot.platform.mapper.*;
import com.atguigu.iot.platform.pojo.*;
import com.atguigu.iot.platform.query.AuthQuery;
import com.atguigu.iot.platform.query.AuthorizeQuery;
import com.atguigu.iot.platform.query.DeviceInfoQuery;
import com.atguigu.iot.platform.service.DeviceInfoService;
import com.atguigu.iot.platform.vo.AuthVo;
import com.atguigu.iot.platform.vo.AuthorizeVo;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;

/***
 * 设备管理的实现类
 */
@Service
public class DeviceInfoServiceImpl
        extends ServiceImpl<DeviceInfoMapper, DeviceInfo>
        implements DeviceInfoService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Autowired
    private ProductInfoMapper productInfoMapper;
    /**
     * 分页条件查询设备列表
     *
     * @param deviceInfoQuery
     * @return
     */
    @Override
    public Page<DeviceInfo> list(DeviceInfoQuery deviceInfoQuery) {
        return deviceInfoMapper.pageDeviceInfoByQuery(
                new Page<DeviceInfo>(deviceInfoQuery.getPageNum(), deviceInfoQuery.getPageSize()),
                deviceInfoQuery);
    }

    /**
     * 新增设备
     *
     * @param deviceInfo
     */
    @Override
    public void saveDeviceInfo(DeviceInfo deviceInfo) {
        //补全设备属性
        deviceInfo.setClientId(RandomUtil.randomString(15));
        deviceInfo.setUsername(RandomUtil.randomString(8));
        deviceInfo.setPassword("atguigu");
        deviceInfo.setCreateBy(StpUtil.getLoginIdAsString());
        deviceInfo.setCreateTime(new Date());
        save(deviceInfo);
    }

    /**
     * 查询设备的信息+设备所属的产品的信息
     *
     * @param id
     * @return
     */
    @Override
    public DeviceInfo getOne(Long id) {
        //查询设备
        DeviceInfo deviceInfo = getOne(
                new LambdaQueryWrapper<DeviceInfo>()
                        .eq(DeviceInfo::getId, id)
                        .eq(DeviceInfo::getStatus, "1"));
        if(deviceInfo == null){
            throw new GuiguException(201, "设备不存在!");
        }
        //查询设备所属的产品
        ProductInfo productInfo =
                productInfoMapper.selectById(deviceInfo.getProductId());
        deviceInfo.setProductInfo(productInfo);
        //返回
        return deviceInfo;
    }

    /**
     * emqx设备接入认证
     *
     * @param authQuery
     * @return
     */
    @Override
    public AuthVo auth(AuthQuery authQuery) {
        //获取参数
        String clientid = authQuery.getClientid();
        String username = authQuery.getUsername();
        String password = authQuery.getPassword();
        //参数校验
        if(StringUtils.isEmpty(clientid) ||
            StringUtils.isEmpty(username) ||
            StringUtils.isEmpty(password)){
            //参数任何错误都是拒绝
            return AuthVo.builder()
                    .is_superuser(false)
                    .result("deny")
                    .build();
        }
        //根据参数查找设备
        DeviceInfo deviceInfo =
                deviceInfoMapper.selectOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getUsername, username)
                                .eq(DeviceInfo::getPassword, password)
                                .eq(DeviceInfo::getStatus, "1")
                                .last("limit 1"));
        if(deviceInfo == null){
            //设备不存在,拒绝连接!!
            return AuthVo.builder()
                    .is_superuser(false)
                    .result("deny")
                    .build();
        }
        //否则就可以允许连接,认证通过
        return AuthVo.builder()
                .is_superuser(deviceInfo.getIsSuperuser().equals("1"))
                .result("allow")
                .build();
    }

    @Autowired
    private ProductTopicMapper productTopicMapper;

    @Autowired
    private ProductModelEventMapper productModelEventMapper;

    @Autowired
    private ProductModelServiceMapper productModelServiceMapper;
    /**
     * 授权
     *
     * @param authorizeQuery
     * @return
     */
    @Override
    public AuthorizeVo authorize(AuthorizeQuery authorizeQuery) {
        //获取客户端id
        String clientid = authorizeQuery.getClientid();
        //获取用户名
        String username = authorizeQuery.getUsername();
        //查询设备
        DeviceInfo deviceInfo =
                deviceInfoMapper.selectOne(
                        new LambdaQueryWrapper<DeviceInfo>()
                                .eq(DeviceInfo::getClientId, clientid)
                                .eq(DeviceInfo::getUsername, username)
                                .eq(DeviceInfo::getStatus, "1")
                                .last("limit 1"));
        //设备存在
        if(deviceInfo != null){
            //获取产品id
            Long productId = deviceInfo.getProductId();
            //获取本次订阅的topic信息: ota/device/inform/im5ev3616a/nkrtfj13ugc34x5
            String topicNow = authorizeQuery.getTopic();
            //设备属于产品的,根据设备的产品id,查询出这个产品的全部的topic
            List<ProductTopic> productTopics =
                    productTopicMapper.selectList(
                            new LambdaQueryWrapper<ProductTopic>()
                                    .eq(ProductTopic::getProductId, productId));
            //遍历找出本次授权的topic在不在这个里面
            long count = productTopics
                    .stream()
                    .filter(productTopic ->
                            //ota/device/inform/im5ev3616a/${clientId}--->ota/device/inform/im5ev3616a/nkrtfj13ugc34x5
                            productTopic.getTopic().replace("${clientId}", clientid).equals(topicNow))
                    .count();
            if(count > 0){
                //找到本次授权的topic,返回允许
                return AuthorizeVo.builder().result("allow").build();
            }
            //查询产品的事件列表
            List<ProductModelEvent> productModelEvents =
                    productModelEventMapper.selectList(
                            new LambdaQueryWrapper<ProductModelEvent>()
                                    .eq(ProductModelEvent::getProductId, productId)
                                    .eq(ProductModelEvent::getStatus, "1")
                                    .select(ProductModelEvent::getIdentifier));
            //判断是否为事件授权
             count = productModelEvents
                    .stream()
                    .filter(//过滤
                            productModelEvent ->//遍历每个事件对象
                                    productTopics.stream().filter(//将产品的每个topic的事件通配符替换为事件的表示Identifier
                                            productTopic ->
                                                    productTopic.getTopic().replace("${clientId}", clientid)//替换客户端id
                                                            .replace("${tsl.event.identifier}", productModelEvent.getIdentifier())//替换事件标识符
                                                            .equals(topicNow)).count() > 0)//判断和本次授权的topic是否匹配,只保留匹配的
                    .count();
             if(count > 0){
                 //找到本次授权的topic,返回允许
                 return AuthorizeVo.builder().result("allow").build();
             }
            //判断是否为服务
            List<ProductModelService> productModelServices =
                    productModelServiceMapper.selectList(
                            new LambdaQueryWrapper<ProductModelService>()
                                    .eq(ProductModelService::getProductId, productId)
                                    .eq(ProductModelService::getStatus, "1")
                                    .select(ProductModelService::getIdentifier));
            count = productModelServices
                    .stream()
                    .filter(//过滤
                            productModelService ->//遍历每个服务对象
                                    productTopics.stream().filter(//将产品的每个topic的服务通配符替换为服务的表示Identifier
                                            productTopic ->
                                                    productTopic.getTopic().replace("${clientId}", clientid)//替换客户端id
                                                            .replace("${tsl.service.identifier}", productModelService.getIdentifier())//替换服务的标识符
                                                            .equals(topicNow)).count() > 0)//判断和本次授权的topic是否匹配,只保留匹配的
                    .count();
            if(count > 0){
                //找到本次授权的topic,返回允许
                return AuthorizeVo.builder().result("allow").build();
            }
        }
        //拒绝
        return AuthorizeVo.builder().result("deny").build();
    }
}
