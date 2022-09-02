package com.listener;

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO 全局监听器
 * @author: LZP
 * @date: 2022年08月18日 17:20
 */
@Component
@Slf4j
public class MyListener implements SaTokenListener {

    /** 每次登录时触发 */
    @Override
    public void doLogin(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel) {
        log.info("id为:"+loginId+"的用户登录--------------------");
    }

    /** 每次注销时触发 */
    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        log.info("id为:"+loginId+"的用户注销--------------------");
    }

    /** 每次被踢下线时触发 */
    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        log.info("id为:"+loginId+"的用户被踢下线--------------------");
    }

    /** 每次被顶下线时触发 */
    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        log.info("id为:"+loginId+"的用户被顶下线--------------------");
    }

    /** 每次被封禁时触发 */
    @Override
    public void doDisable(String loginType, Object loginId, long disableTime) {
        log.info("id为:"+loginId+"的用户被封禁--------------------");
    }

    /** 每次被解封时触发 */
    @Override
    public void doUntieDisable(String loginType, Object loginId) {
        log.info("id为:"+loginId+"的用户已解封--------------------");
    }

    /** 每次创建Session时触发 */
    @Override
    public void doCreateSession(String id) {
    }

    /** 每次注销Session时触发 */
    @Override
    public void doLogoutSession(String id) {
    }

}


