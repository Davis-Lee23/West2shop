package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.entity.Into;
import com.service.IntoDetailService;
import com.service.IntoService;
import com.vo.IntoPage;
import com.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:25
 */
@RestController
@RequestMapping("/shop/into")
@Slf4j
@CrossOrigin
public class IntoController {

    @Autowired
    private IntoService intoService;
    @Autowired
    private IntoDetailService intoDetailService;


    /**
    * TODO 查询入库记录
    * @author: LZP
    * @date: 2022/8/22 16:23
    * @param pageNo:
    * @param pageSize:
    * @param req:
    * @return: com.vo.Result<?>
    */
    @GetMapping("/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   String shopId,
                                   HttpServletRequest req){
        //获取主表数据
        Page<Into> page = new Page<>(pageNo,pageSize);
        IPage<Into> pageList = intoService.page(page,new LambdaQueryWrapper<Into>()
                .eq(Into::getDelFlag, CommonConstant.DEL_FLAG_0)
                .eq(Into::getShopId,shopId));
        //获取附表数据
        intoDetailService.getIntoDetail(pageList.getRecords());
        return Result.OK(pageList);
    }

    /**
    * TODO 入库
    * @author: LZP
    * @date: 2022/8/22 16:23
    * @param intoPage:
    * @return: com.vo.Result<?>
    */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody IntoPage intoPage){
        Into into = new Into();
        BeanUtils.copyProperties(intoPage,into);
        into.setCreateTime(new Date());
        intoService.savaMain(into,intoPage.getIntoDetailList());
        return Result.OK(CommonConstant.ADD_SUCCESS);
    }

    /**
    * TODO 编辑入库单
    * @author: LZP
    * @date: 2022/8/22 16:23
    * @param intoPage:
    * @return: com.vo.Result<?>
    */
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody IntoPage intoPage){
        Into into = new Into();
        BeanUtils.copyProperties(intoPage,into);
        Into entity = intoService.getById(into.getId());
        if(entity == null){
            return Result.error(ErrorConstant.NOT_FOUND_DATA);
        }
        intoService.updateMain(into, intoPage.getIntoDetailList());
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    /**
    * TODO 删除入库单
    * @author: LZP
    * @date: 2022/8/22 16:23
    * @param id:
    * @return: com.vo.Result<?>
    */
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id") String id){
        intoService.delMain(id);
        return Result.OK(CommonConstant.DELETE_SUCCESS);
    }
}
