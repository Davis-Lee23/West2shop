package com.handler;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: TODO 注册Sa-Token的注解拦截器，打开注解式鉴权功能
 * @author: LZP
 * @date: 2022年09月02日 11:26
 */
@Configuration
@EnableWebMvc
public class SaTokenHandler implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册注解拦截器，并排除不需要注解鉴权的接口地址 (与登录拦截器无关)
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}
