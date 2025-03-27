package com.atguigu.iot.platform.query;

import lombok.Data;

@Data
public class DeviceAtrrDataQuery {

    private Integer pageNum;

    private Integer pageSize;

    private Long deviceId;

    private Long modelAttrId;

}
