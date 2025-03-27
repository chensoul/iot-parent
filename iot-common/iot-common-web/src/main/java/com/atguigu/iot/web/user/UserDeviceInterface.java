package com.atguigu.iot.web.user;

/***
 * 通用接口类
 */
public interface UserDeviceInterface {

    /**
     * 修改设备的在线状态
     * @param clientId
     * @param status
     */
     void updateUserDeviceRunStatus(String clientId, String status);

    /**
     * 查询设备的运行状态
     * @param clientId
     * @return
     */
    String getRunStatus(String clientId);
}
