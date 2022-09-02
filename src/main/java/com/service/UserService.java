package com.service;

import com.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vo.Result;

/**
* @author LBJ
* @description 针对表【west_user】的数据库操作Service
* @createDate 2022-08-24 18:10:40
*/
public interface UserService extends IService<User> {

    /**
    * TODO 登录认证
    * @author: LZP
    * @date: 2022/9/2 10:30
    * @param phone :
    * @param pwd :
    * @return: void
    */
    Result<?> doLogin(String phone, String pwd);
}
