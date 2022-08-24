package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Permission;
import com.service.PermissionService;
import com.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author LBJ
* @description 针对表【west_permission】的数据库操作Service实现
* @createDate 2022-08-24 11:21:05
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




