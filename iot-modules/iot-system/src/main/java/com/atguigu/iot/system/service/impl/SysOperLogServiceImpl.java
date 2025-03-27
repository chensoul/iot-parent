package com.atguigu.iot.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.mapper.SysOperLogMapper;
import com.atguigu.iot.system.mapper.SysUserMapper;
import com.atguigu.iot.system.pojo.SysOperLog;
import com.atguigu.iot.system.pojo.SysUser;
import com.atguigu.iot.system.service.SysOperLogService;
import com.atguigu.iot.system.util.IpUtil;
import com.atguigu.iot.system.vo.SysOperLogVo;
import com.atguigu.iot.web.log.OperLogCache;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/***
 * 操作日志相关的接口类
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysOperLogServiceImpl
        extends ServiceImpl<SysOperLogMapper, SysOperLog>
        implements SysOperLogService {

    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 操作日志分页条件查询
     *
     * @param sysOperLogVo
     * @return
     */
    @Override
    public Page<SysOperLog> list(SysOperLogVo sysOperLogVo) {
        return sysOperLogMapper.selectSysOperLogByVo(
                new Page<SysOperLog>(sysOperLogVo.getPageNum(), sysOperLogVo.getPageSize()),
                sysOperLogVo);
    }

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 保存操作日志
     *
     * @param sysOperLog
     * @param point
     */
    @Override
    public void saveSysOperLog(SysOperLog sysOperLog, JoinPoint point) {
        //获取方法的签名对象
        MethodSignature signature = (MethodSignature)point.getSignature();
        //获取方法对象
        Method method = signature.getMethod();
        //获取方法的注解属性
        OperLogCache operLogCache = method.getAnnotation(OperLogCache.class);
        //保存模块的名字
        sysOperLog.setTitle(operLogCache.title());
        //方法的名字
        sysOperLog.setMethod(method.getDeclaringClass().getName() + ":" + method.getName());
        //获取请求对象
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //请求的方式
        sysOperLog.setRequestMethod(request.getMethod());
        //操作类别
        sysOperLog.setOperatorType(operLogCache.operatorType().name());
        //操作人
        SysUser sysUser =
                sysUserMapper.selectById(StpUtil.getLoginIdAsLong());
        sysOperLog.setOperName(sysUser.getUsername());
        //请求url
        sysOperLog.setOperUrl(request.getRequestURI());
        //请求的ip地址
        sysOperLog.setOperIp(IpUtil.getIpAddress(request));
        //请求的参数
        sysOperLog.setOperParam(JSONObject.toJSONString(request.getParameterMap()));
        //保存操作日志
        sysOperLogMapper.insert(sysOperLog);
    }
}
