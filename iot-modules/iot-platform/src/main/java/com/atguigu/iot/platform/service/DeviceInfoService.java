package com.atguigu.iot.platform.service;

import com.atguigu.iot.platform.pojo.DeviceInfo;
import com.atguigu.iot.platform.query.AuthQuery;
import com.atguigu.iot.platform.query.AuthorizeQuery;
import com.atguigu.iot.platform.query.DeviceInfoQuery;
import com.atguigu.iot.platform.vo.AuthVo;
import com.atguigu.iot.platform.vo.AuthorizeVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


/***
 * 设备管理的接口类
 */
public interface DeviceInfoService extends IService<DeviceInfo> {
    /**
     * 分页条件查询设备列表
     * @param deviceInfoQuery
     * @return
     */
    Page<DeviceInfo> list(DeviceInfoQuery deviceInfoQuery);

    /**
     * 新增设备
     * @param deviceInfo
     */
    void saveDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 查询设备的信息+设备所属的产品的信息
     * @param id
     * @return
     */
    DeviceInfo getOne(Long id);

    /**
     * emqx设备接入认证
     * @param authQuery
     * @return
     */
    AuthVo auth(AuthQuery authQuery);

    /**
     * 授权
     * @param authorizeQuery
     * @return
     */
    AuthorizeVo authorize(AuthorizeQuery authorizeQuery);
}
