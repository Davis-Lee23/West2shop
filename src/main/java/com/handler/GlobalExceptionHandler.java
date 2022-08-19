package com.handler;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: TODO 全局权限异常处理-懒人标配
 * @author: LZP
 * @date: 2022年08月18日 17:18
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }
}

