package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.common.Result;
import com.entity.Types;
import com.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:25
 */
@RestController
@RequestMapping("/shop/types")
@Slf4j
public class TypesController {
    @Autowired
    private TypesService typesService;

    /**
    * TODO  分页列表查询
    * @author: LZP
    * @date: 2022/8/17 17:21
    * @param pageNo:
    * @param pageSize:
    * @param req:
    * @return: com.common.Result<?>
    */
    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                   HttpServletRequest req){
        Page<Types> page = new Page<>(pageNo, pageSize);
        IPage<Types> pageList = typesService.page(page,new LambdaQueryWrapper<Types>().isNull(Types::getLink));
        return Result.OK(pageList);
    }

    @PostMapping
    public Result<?> add(@RequestBody Types types){
        typesService.save(types);
        return Result.OK("添加成功");
    }
}