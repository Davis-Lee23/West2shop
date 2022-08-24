package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.entity.Out;
import com.service.OutService;
import com.vo.OutDataVO;
import com.vo.OutPage;
import com.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:25
 */
@RestController
@RequestMapping("/shop/out")
@Slf4j
@CrossOrigin
public class OutController {

    @Autowired
    private OutService outService;

    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   String shopId, HttpServletRequest req){
        //获取主表数据
        Page<Out> page = new Page<>(pageNo,pageSize);
        IPage<Out> pageList = outService.page(page,new LambdaQueryWrapper<Out>()
                .eq(Out::getDelFlag, CommonConstant.DEL_FLAG_0)
                .eq(Out::getShopId,shopId));
        //获取附表数据
        outService.getOutDetail(pageList.getRecords());
        return Result.OK(pageList);
    }

/*    @PostMapping(value = "/uploadImage")
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
    }*/

    /**
    * TODO 新增
    * @author: LZP
    * @date: 2022/8/24 10:41
    * @param data:
    * @return: com.vo.Result<?>
    */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody OutDataVO data){
        outService.addByData(data);
        return Result.OK(CommonConstant.ADD_SUCCESS);
    }

    /**
    * TODO 编辑
    * @author: LZP
    * @date: 2022/8/24 10:41
    * @param outPage:
    * @return: com.vo.Result<?>
    */
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody OutPage outPage){
        Out out = new Out();
        BeanUtils.copyProperties(outPage,out);
        Out entity = outService.getById(out.getId());
        if (entity == null){
            return Result.error(ErrorConstant.NOT_FOUND_DATA);
        }
        outService.updateMain(out,outPage.getOutDetailList());
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    /**
    * TODO 删除
    * @author: LZP
    * @date: 2022/8/24 10:41
    * @param id:
    * @return: com.vo.Result<?>
    */
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id") String id){
        outService.delMain(id);
        return Result.OK(CommonConstant.DELETE_SUCCESS);
    }

}
