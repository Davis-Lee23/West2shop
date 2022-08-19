package com.service;

import com.entity.Good;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author admin
 * @description 针对表【west_good】的数据库操作Service
 * @createDate 2022-08-17 16:07:37
 */
public interface GoodService extends IService<Good> {

    /**
    * TODO 检查商品是否存在
    * @author: LZP
    * @date: 2022/8/19 10:56
    * @param id:
    * @return: boolean
    */
    boolean check(String id);
}
