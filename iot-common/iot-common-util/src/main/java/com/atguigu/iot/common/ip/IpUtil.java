package com.atguigu.iot.common.ip;

import cn.hutool.core.net.NetUtil;
import jakarta.servlet.http.HttpServletRequest;

public class IpUtil {

    public static String getClientIPByHeader(HttpServletRequest request) {
        String[] headers = new String[]{"X-Forwarded-For",
                "X-Real-IP",
                "Proxy-Client-IP",
                "WL-Proxy-Client-IP",
                "HTTP_CLIENT_IP",
                "HTTP_X_FORWARDED_FOR"};
        int var4 = headers.length;

        String ip;
        for(int var5 = 0; var5 < var4; ++var5) {
            String header = headers[var5];
            ip = request.getHeader(header);
            if (!NetUtil.isUnknown(ip)) {
                return NetUtil.getMultistageReverseProxyIp(ip);
            }
        }
        ip = request.getRemoteAddr();
        return NetUtil.getMultistageReverseProxyIp(ip);
    }
}
