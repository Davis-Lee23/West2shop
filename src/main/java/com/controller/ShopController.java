package com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.entity.Good;
import com.entity.Shop;
import com.service.GoodService;
import com.service.ShopService;
import com.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:24
 */
@RestController
@RequestMapping("/shop/shop")
@Slf4j
public class ShopController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private GoodService goodService;

    /**
    * TODO 分页查询商店
    * @author: LZP
    * @date: 2022/8/19 16:12
    * @param pageNo:
    * @param pageSize:
    * @param req:
    * @return: com.vo.Result<?>
    */
    @GetMapping("/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req){
        Page<Shop> page = new Page<>(pageNo, pageSize);
        IPage<Shop> pageList = shopService.page(page, new LambdaQueryWrapper<Shop>()
                .eq(Shop::getDelFlag, CommonConstant.DEL_FLAG_0));
        return Result.OK(pageList);
    }

    /**
    * TODO 添加商店
    * @author: LZP
    * @date: 2022/8/19 16:13
    * @param shop:
    * @return: com.vo.Result<?>
    */
    @PostMapping("/add")
    public Result<?> add(@RequestBody Shop shop){
        try {
            shop.setCreateTime(new Date());
            shop.setDelFlag(CommonConstant.DEL_FLAG_0);
            shopService.save(shop);
        }catch (Exception e){
            throw new RuntimeException("添加商店出现异常");
        }
        return Result.OK("添加商店成功");
    }

    /**
    * TODO 编辑
    * @author: LZP
    * @date: 2022/8/19 16:13
    * @param shop:
    * @return: com.vo.Result<?>
    */
    @PutMapping("/edit")
    public Result<?> edit(@RequestBody Shop shop){
        shopService.updateById(shop);
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    /**
    * TODO 删除
    * @author: LZP
    * @date: 2022/8/19 16:13
    * @param id:
    * @return: com.vo.Result<?>
    */
    @DeleteMapping("/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
        shopService.removeById(id);
        return Result.OK(CommonConstant.DELETE_SUCCESS);
    }

    /**
     * TODO 根据id查库存
     * @author: LZP
     * @date: 2022/8/19 16:13
     * @param id:
     * @return: com.vo.Result<?>
     */
    @GetMapping("/queryStock")
    public Result<?> queryStock(@RequestParam(name = "id", required = true) String id) {
        List<Good> list = goodService.list(new LambdaQueryWrapper<Good>()
                .eq(Good::getShopId,id));
        return Result.OK(list);
    }
}
