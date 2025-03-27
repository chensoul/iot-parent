package com.atguigu.iot.platform.service;

import com.alibaba.fastjson2.JSONObject;

public interface CommontProductEventService {

    /**
     * 根据产品的key和标识符获取产品的事件详细信息
     * @param key
     * @param identifier
     * @param value
     * @return
     */
    String getProductModelEventInfo(String key, String identifier, JSONObject value);
}
