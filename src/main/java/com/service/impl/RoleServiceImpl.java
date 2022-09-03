package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Role;
import com.service.RoleService;
import com.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author LBJ
* @description 针对表【west_role】的数据库操作Service实现
* @createDate 2022-09-02 16:45:46
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




