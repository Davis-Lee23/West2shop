package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.UserPermission;
import com.service.UserPermissionService;
import com.mapper.UserPermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author LBJ
* @description 针对表【west_user_permission】的数据库操作Service实现
* @createDate 2022-08-24 11:21:05
*/
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission>
    implements UserPermissionService{

}




