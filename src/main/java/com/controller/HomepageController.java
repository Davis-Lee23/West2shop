package com.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
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
    @Cache(expire = 5*60*1000,name = "hot_good")
    public Result<?> hotGoods(String shopId){
        return Result.OK(homepageService.hotGoods(shopId));
    }

    @GetMapping(value = "/timeSlots")
    @Cache(expire = 5*60*100,name = "time")
    public Result<?> timeSlots(String shopId){
        return Result.OK(homepageService.timeSlots(shopId));
    }

    @GetMapping(value = "/saToken")
    public Result<?> test(){
        StpUtil.login(10001);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        // 第3步，返回给前端
        return Result.OK(tokenInfo);
    }
}
