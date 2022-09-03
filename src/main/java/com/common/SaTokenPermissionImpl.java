package com.common;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.entity.User;
import com.entity.UserRole;
import com.mapper.RoleMapper;
import com.mapper.UserRoleMapper;
import com.service.RoleService;
import com.service.UserRoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO 自定义权限验证接口扩展，权限&角色互不干扰
 * @author: LZP
 * @date: 2022年09月02日 14:44
 */
@Component
public class SaTokenPermissionImpl implements StpInterface {

    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;

    /**
    * TODO 返回一个账号所有的权限码集合
    * @author: LZP
    * @date: 2022/9/2 14:45
    * @param loginId:
    * @param loginType:
    * @return: java.util.List<java.lang.String>
    */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    /**
    * TODO 返回一个账号所有的角色标识集合
    * @author: LZP
    * @date: 2022/9/2 14:46
    * @param loginId:
    * @param loginType:
    * @return: java.util.List<java.lang.String>
    */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        //得到用户id
        List<String> list = new ArrayList<>();
        //获取关联表所有的角色id
        List<String> roleIds = userRoleMapper.selectRoles((String) loginId);
        //获取角色名称
        for(String roleId : roleIds){
            list.add(roleMapper.selectById(roleId).getRole());
        }
        return list;
    }
}
