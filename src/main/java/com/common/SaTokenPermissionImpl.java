package com.common;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO 自定义权限验证接口扩展，权限&角色互不干扰
 * @author: LZP
 * @date: 2022年09月02日 14:44
 */
@Component
public class SaTokenPermissionImpl implements StpInterface {

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
        if(loginId.equals("18759482488")){
            System.out.println("这个有角色");
        }
        List<String> list = new ArrayList<String>();
        list.add("test");
        return list;
    }
}
