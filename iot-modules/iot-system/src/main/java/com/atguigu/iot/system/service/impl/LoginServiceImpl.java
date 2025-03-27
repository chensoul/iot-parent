package com.atguigu.iot.system.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.AlgorithmUtil;
import com.alibaba.fastjson2.JSONObject;
import com.atguigu.iot.system.mapper.SysLoginLogMapper;
import com.atguigu.iot.system.mapper.SysUserMapper;
import com.atguigu.iot.system.pojo.SysLoginLog;
import com.atguigu.iot.system.pojo.SysUser;
import com.atguigu.iot.system.service.LoginService;
import com.atguigu.iot.system.util.IpUtil;
import com.atguigu.iot.system.vo.LoginVo;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/***
 * 登录相关接口的实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;
    /**
     * 登录
     *
     * @param loginVo
     * @return
     */
    @Override
    public JSONObject login(LoginVo loginVo,
                            HttpServletRequest request) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setUsername(loginVo.getUsername());
        sysLoginLog.setAccessTime(new Date());
        sysLoginLog.setMsg("登录成功");
        sysLoginLog.setStatus(0);
        sysLoginLog.setIpaddr(IpUtil.getIpAddress(request));
        //返回结果初始化
        JSONObject result = new JSONObject();
        try {
            //校验验证码
            String codeKey = loginVo.getCodeKey();
            String captcha = loginVo.getCaptcha();
            //从redis中获取验证码的信息
            String redisData = (String)redisTemplate.opsForValue().get(codeKey);
            if(StringUtils.isEmpty(redisData) ||
                    !redisData.equals(captcha)){
                throw new GuiguException(201, "验证码错误!");
            }
            //清理验证码
            redisTemplate.delete(codeKey);
            //校验用户名和密码
            String username = loginVo.getUsername();
            SysUser sysUser =
                    sysUserMapper.selectOne(
                            new LambdaQueryWrapper<SysUser>()
                                    .eq(SysUser::getUsername, username));
            if(sysUser == null){
                throw new GuiguException(201, "用户不存在!");
            }
            //获取数据库的密码: 密文
            String passwordDb = sysUser.getPassword();
            //密码是用户给的登录密码: 明文
            String password = loginVo.getPassword();
            if(!BCrypt.checkpw(password, passwordDb)){
                throw new GuiguException(201, "密码错误!");
            }
            //校验状态
            if(sysUser.getStatus().equals(0)){
                throw new GuiguException(201, "账号状态异常,请联系管理员!");
            }
            //使用sa-token框架记录登录状态
            StpUtil.login(sysUser.getId());
            //获取token
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            result.put("token", tokenInfo.getTokenValue());
        }catch (Exception e){
            //登录失败
            sysLoginLog.setStatus(1);
            //登录失败的原因
            sysLoginLog.setMsg("登录失败,失败的原因为:" + e.getMessage());
            throw e;
        }finally {
            //记录登录日志: 同步保存影响登录的性能--->优化为异步操作
            CompletableFuture.runAsync(()->{
                sysLoginLogMapper.insert(sysLoginLog);
            });
        }
        //返回
        return result;
    }
}
