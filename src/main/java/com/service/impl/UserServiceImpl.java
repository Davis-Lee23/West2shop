package com.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.entity.User;
import com.service.UserService;
import com.mapper.UserMapper;
import com.util.RedisCache;
import com.vo.Result;
import com.vo.param.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
* @author LBJ
* @description 针对表【west_user】的数据库操作Service实现
* @createDate 2022-08-24 18:10:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public Result<?> doLogin(LoginParam loginParam) {
        String phone = loginParam.getPhone();
        String pwd = loginParam.getPwd();
        String captcha = loginParam.getCaptcha();
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getPhone,phone));
        if(user == null){
            return Result.error("该用户不存在");
        }
        if(redisCache.getCacheObject(captcha) == null){
            return Result.error(ErrorConstant.CAPTCHA_ERROR);
        }
        //md5加密盐判断
        if(SaSecureUtil.md5BySalt(pwd, CommonConstant.SALT).equals(user.getPwd())){
            StpUtil.login(user.getPhone());
            //获取token,并存入redis
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            redisCache.setCacheObject(tokenInfo.getTokenValue(),phone,120, TimeUnit.MINUTES);
            return Result.OK(tokenInfo.getTokenValue());
        }
        return Result.error("密码不正确");
    }
}




