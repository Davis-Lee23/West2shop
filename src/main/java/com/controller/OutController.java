package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.entity.Out;
import com.service.OutService;
import com.vo.OutDataVO;
import com.vo.OutPicVo;
import com.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:25
 */
@RestController
@RequestMapping("/shop/out")
@Slf4j
public class OutController {

    @Autowired
    private OutService outService;

    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req){
        //获取主表数据
        Page<Out> page = new Page<>(pageNo,pageSize);
        IPage<Out> pageList = outService.page(page,new LambdaQueryWrapper<Out>()
                .eq(Out::getDelFlag, CommonConstant.DEL_FLAG_0));
        //获取附表数据
        outService.getOutDetail(pageList.getRecords());
        return Result.OK(pageList);
    }

    @PostMapping(value = "/uploadImage")
    public Result<?> uploadImage(@RequestParam("image") MultipartFile file){
        String url = outService.uploadImg(file);
        Out out = new Out();
        out.setPic(url);
        outService.save(out);
        return Result.OK(new OutPicVo(out.getId(), out.getPic()));
    }

    @PutMapping(value = "/completeData")
    public Result<?> completeData(@RequestBody OutDataVO outData){
        System.out.println(outData);
        outService.completeData(outData);
        return Result.OK("出库数据补全成功");
    }
}
