package com.common.cache;

/**
 * @Description: TODO 缓存处理
 * @author: LZP
 * @date: 2022年08月26日 18:38
 */
import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1 * 60 * 1000;

    String name() default "";

}

