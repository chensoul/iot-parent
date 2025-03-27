package com.atguigu.iot.user.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.dev33.satoken.stp.StpUtil;
import com.atguigu.iot.user.mapper.UserInfoMapper;
import com.atguigu.iot.user.pojo.UserInfo;
import com.atguigu.iot.user.service.UserInfoService;
import com.atguigu.iot.user.vo.UserInfoVo;
import com.atguigu.iot.web.execption.GuiguException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * 用户相关的操作接口类的实现类
 */
@Service
public class UserInfoServiceImpl
        extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {

    @Autowired
    private WxMaService wxMaService;

    /**
     * 小程序登录
     *
     * @param code
     * @return
     */
    @Override
    public String wxLogin(String code) {
        //判断code是否为空
        if(StringUtils.isEmpty(code)){
            throw new GuiguException(201, "小程序登录code参数错误!");
        }
        try {
            //使用小程序登录bean完成登录
            WxMaJscode2SessionResult wxMaJscode2SessionResult = wxMaService.jsCode2SessionInfo(code);
            //获取微信返回的用户的唯一标识openId
            String openid = wxMaJscode2SessionResult.getOpenid();
            //数据库中查询这个用户是否登录过
            UserInfo userInfo =
                    getOne(
                            new LambdaQueryWrapper<UserInfo>()
                                    .eq(UserInfo::getOpenId, openid));
            if(userInfo == null){
                //用户第一次登录: 初始化
                userInfo = new UserInfo();
                userInfo.setUsername("shangguigu");
                userInfo.setNickName("尚硅谷用户");
                userInfo.setPhone("13333333333");
                userInfo.setSex(1);
                userInfo.setAvatar("https://www.atguigu.com/images/index_new/logo.png");
                userInfo.setLastLoginTime(new Date());
                userInfo.setOpenId(openid);
                //保存用户数据
                save(userInfo);
            }else{
                //非第一次登录的用户
                userInfo.setLastLoginTime(new Date());
                updateById(userInfo);
            }
            //在sa-token框架声明登录
            StpUtil.login(userInfo.getId());
            //获取token
            return StpUtil.getTokenInfo().getTokenValue();
        }catch (Exception e){
            e.printStackTrace();
            throw new GuiguException(201, "登录失败,请重试!");
        }
    }

    /**
     * 查询用户信息接口
     *
     * @return
     */
    @Override
    public Object getLoginUserInfo() {
        //获取用户的id
        long loginIdAsLong = StpUtil.getLoginIdAsLong();
        //查询用户的信息
        UserInfo userInfo = getById(loginIdAsLong);
        //返回结果初始化
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setAvatar(userInfo.getAvatar());
        userInfoVo.setNickName(userInfo.getNickName());
        return userInfoVo;
    }
}
