package com.controller;

import com.common.cache.Cache;
import com.service.HomepageService;
import com.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO 主页
 * @author: LZP
 * @date: 2022年08月24日 15:29
 */
@RestController
@RequestMapping("/shop/home")
@CrossOrigin
public class HomepageController {

    @Autowired
    private HomepageService homepageService;

    /**
    * TODO 热搜商品，SQL分组函数
    * @author: LZP
    * @date: 2022/8/24 16:15
    * @return: com.vo.Result<?>
    */
    @GetMapping(value = "/hotGoods")
    public Result<?> hotGoods(String shopId){
        return Result.OK(homepageService.hotGoods(shopId));
    }

    @GetMapping(value = "/timeSlots")
    public Result<?> timeSlots(String shopId){
        return Result.OK(homepageService.timeSlots(shopId));
    }

}
