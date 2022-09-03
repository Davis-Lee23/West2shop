package com.mapper;

import com.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author LBJ
* @description 针对表【west_user_role】的数据库操作Mapper
* @createDate 2022-08-24 11:21:05
* @Entity com.entity.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
    * TODO 根据id，获取所有的角色
    * @author: LZP
    * @date: 2022/9/2 16:59
    * @param phone:
    * @return: java.util.List<java.lang.String>
    */
    List<String> selectRoles(String phone);
}




