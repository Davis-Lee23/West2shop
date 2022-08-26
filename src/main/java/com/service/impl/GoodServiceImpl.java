package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.entity.Good;
import com.service.GoodService;
import com.mapper.GoodMapper;
import com.service.ShopService;
import com.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author admin
* @description 针对表【west_good】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService{

    @Resource
    private GoodMapper goodMapper;
    @Autowired
    private ShopService shopService;
    @Autowired
    private TypesService typesService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean check(String id) {
        Good good = goodMapper.selectById(id);
        if(good != null && good.getDelFlag().equals(CommonConstant.DEL_FLAG_0)){
            if(shopService.check(good.getShopId()) && typesService.check(good.getType())){
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void errorCheck(Good good) {
        if(good == null){
            throw new RuntimeException(ErrorConstant.IZ_NULL);
        }
        if(good.getPreStock() == null){
            good.setPreStock(0);
        }
        if(goodMapper.selectById(good.getId()) != null){
            throw new RuntimeException(ErrorConstant.DUPLICATE_DATA);
        }
    }
}




