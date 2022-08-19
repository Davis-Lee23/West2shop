package com.service;

import com.entity.Good;
import com.entity.Shop;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author admin
 * @description 针对表【west_shop】的数据库操作Service
 * @createDate 2022-08-17 16:07:37
 */
public interface ShopService extends IService<Shop> {

    /**
    * TODO 检测商店是否存在
    * @author: LZP
    * @date: 2022/8/19 10:20
    * @param id:
    * @return: boolean
    */
    boolean check(String id);
}
