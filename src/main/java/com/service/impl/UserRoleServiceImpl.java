package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.UserRole;
import com.service.UserRoleService;
import com.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author LBJ
* @description 针对表【west_user_role】的数据库操作Service实现
* @createDate 2022-08-24 11:21:05
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




