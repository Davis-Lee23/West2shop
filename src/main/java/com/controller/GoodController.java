package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vo.Result;
import com.constant.CommonConstant;
import com.entity.Good;
import com.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:24
 */
@RestController
@RequestMapping("/shop/good")
@Slf4j
public class GoodController {

    @Autowired
    private GoodService goodService;

    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {
        Page<Good> page = new Page<>(pageNo, pageSize);
        IPage<Good> pageList = goodService.page(page, new LambdaQueryWrapper<Good>()
                .eq(Good::getDelFlag, CommonConstant.DEL_FLAG_0));
        return Result.OK(pageList);
    }
}
