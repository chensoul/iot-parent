package com.atguigu.iot.system.util;

import cn.hutool.core.net.NetUtil;
import jakarta.servlet.http.HttpServletRequest;

/***
 * 获取ip地址用的
 */
public class IpUtil {

    /**
     * 获取客户端的ip地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request){
        //定义个请求头对象
        String[] headers =
                new String[]{"X-Forwarded-For", "X-Real-IP",
                        "Proxy-Client-IP", "WL-Proxy-Client-IP",
                        "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
        //请求头参数的长度
        int var4 = headers.length;
        //ip地址对象
        String ip;
        //循环去获取request请求头中固定参数的值
        for(int var5 = 0; var5 < var4; ++var5) {
            String header = headers[var5];
            ip = request.getHeader(header);
            if (!NetUtil.isUnknown(ip)) {
                return NetUtil.getMultistageReverseProxyIp(ip);
            }
        }
        //解析到ip地址返回
        ip = request.getRemoteAddr();
        return NetUtil.getMultistageReverseProxyIp(ip);
    }

}
