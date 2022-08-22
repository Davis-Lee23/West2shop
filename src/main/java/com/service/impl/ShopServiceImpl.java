package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.entity.Shop;
import com.service.ShopService;
import com.mapper.ShopMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author admin
* @description 针对表【west_shop】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService{

    @Resource
    private ShopMapper shopMapper;

    @Override
    public boolean check(String id) {
        Shop shop = shopMapper.selectById(id);
        //商店存在，且没有被软删除
        return shop != null && shop.getDelFlag().equals(CommonConstant.DEL_FLAG_0);
    }
}




