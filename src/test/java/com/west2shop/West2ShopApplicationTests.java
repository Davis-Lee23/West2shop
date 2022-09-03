package com.west2shop;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.entity.Out;
import com.entity.UserRole;
import com.mapper.GoodMapper;
import com.mapper.OutMapper;
import com.mapper.RoleMapper;
import com.mapper.UserRoleMapper;
import com.service.RoleService;
import com.service.UserRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class West2ShopApplicationTests {

    @Resource
    private GoodMapper goodMapper;
    @Resource
    private OutMapper outMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;


    @Test
    public void context(){
        List<Out> goods = outMapper.selectList(null);
        System.out.println("列表:"+goods);
    }

    @Test
    public void saTokenTest(){
        String phone = "123456";
        List<String> list = new ArrayList<>();
        //获取关联表所有的角色id
        List<String> roleIds = userRoleMapper.selectRoles(phone);
        //获取角色名称
        for(String roleId : roleIds){
            list.add(roleMapper.selectById(roleId).getRole());
        }
        System.out.println(list);
        System.out.println();
    }
}
