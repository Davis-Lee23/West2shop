package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.User;
import com.service.UserService;
import com.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【west_user】的数据库操作Service实现
* @createDate 2022-08-18 17:11:30
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}



