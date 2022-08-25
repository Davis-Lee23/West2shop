package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.entity.Good;
import com.entity.Supplier;
import com.entity.SupplierGood;
import com.service.GoodService;
import com.service.SupplierGoodService;
import com.service.SupplierService;
import com.vo.Result;
import com.vo.param.IdsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月25日 21:38
 */
@RestController
@RequestMapping("/shop/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private SupplierGoodService supplierGoodService;

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/25 22:40
    * @param pageNo:
    * @param pageSize:
    * @param req:
    * @return: com.vo.Result<?>
    */
    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req){
        Page<Supplier> page = new Page<>(pageNo, pageSize);
        IPage<Supplier> pageList = supplierService.page(page, new LambdaQueryWrapper<Supplier>()
                .eq(Supplier::getDelFlag, CommonConstant.DEL_FLAG_0));
        return Result.OK(pageList);
    }

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/25 22:40
    * @param supplier:
    * @return: com.vo.Result<?>
    */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody Supplier supplier){
        Date date = new Date();
        supplier.setCreateTime(date);
        supplier.setUpdateTime(date);
        supplier.setDelFlag(CommonConstant.DEL_FLAG_0);
        supplierService.save(supplier);
        return Result.OK(CommonConstant.ADD_SUCCESS);
    }

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/25 22:40
    * @param supplier:
    * @return: com.vo.Result<?>
    */
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody Supplier supplier){
        Date date = new Date();
        supplier.setUpdateTime(date);
        supplierService.updateById(supplier);
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/25 22:40
    * @param id:
    * @return: com.vo.Result<?>
    */
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name="id") String id) {
        if(supplierService.removeById(id)){
            return Result.OK(CommonConstant.DELETE_SUCCESS);
        }else {
            return Result.OK(ErrorConstant.NOT_FOUND_DATA);
        }
    }

    @GetMapping(value = "/listGoods")
    public Result<?> listGoods(String supplierId){
        //获取关联表id
        List<SupplierGood> list = supplierGoodService.list(new LambdaQueryWrapper<SupplierGood>()
                .eq(SupplierGood::getSupplierId,supplierId));
        List<Good> res = new ArrayList<>();
        try {
            for (SupplierGood entity : list) {
                Good good = goodService.getById(entity.getGoodId());
                res.add(good);
            }
        }catch (Exception e){
            throw new RuntimeException(ErrorConstant.GOOD_NOT_FOUND);
        }
        return Result.OK(res);
    }

    /**
    * TODO 添加供应商商品
    * @author: LZP
    * @date: 2022/8/25 22:40
    * @param ids:
    * @return: com.vo.Result<?>
    */
    @PostMapping(value = "/addGoods")
    public Result<?> addGoods(@RequestBody IdsParam ids){
        if(ids == null || ids.getIds()==null || ids.getSupplierId()==null){
            throw new RuntimeException(ErrorConstant.ID_IZ_NULL);
        }
        supplierService.addGoods(ids);
        return Result.OK(CommonConstant.ADD_SUCCESS);
    }

    /**
    * TODO 编辑
    * @author: LZP
    * @date: 2022/8/25 23:35
    * @param ids:
    * @return: com.vo.Result<?>
    */
    @PutMapping(value = "/editGoods")
    public Result<?> editGoods(@RequestBody IdsParam ids){
        if(ids == null || ids.getIds()==null || ids.getSupplierId()==null){
            throw new RuntimeException(ErrorConstant.ID_IZ_NULL);
        }
        supplierService.updateGoods(ids);
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }
}
