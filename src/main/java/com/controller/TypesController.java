package com.controller;

import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.vo.Result;
import com.entity.Types;
import com.service.TypesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO 分类接口
 * @author: LZP
 * @date: 2022年08月17日 16:25
 */
@RestController
@RequestMapping("/shop/types")
@Slf4j
@CrossOrigin
public class TypesController {
    @Autowired
    private TypesService typesService;

    /**
    * TODO  分类查询,没有使用分页
    * @author: LZP
    * @date: 2022/8/17 17:21
    * @return: com.vo.Result<?>
    */
    @GetMapping(value = "/list")
    public Result<?> queryPageList(){
        return Result.OK(typesService.listWithTree());
    }

    /**
    * TODO 分类添加
    * @author: LZP
    * @date: 2022/8/18 14:14
    * @param types:
    * @return: com.vo.Result<?>
    */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody Types types){
        types.setDelFlag(CommonConstant.DEL_FLAG_0);
        typesService.save(types);
        return Result.OK(CommonConstant.ADD_SUCCESS);
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody Types types){
        typesService.updateById(types);
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id") String id){
        if(typesService.removeById(id)){
            return Result.OK(CommonConstant.DELETE_SUCCESS);
        }else {
            return Result.OK(ErrorConstant.NOT_FOUND_DATA);
        }
    }
}
