package com.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.ErrorConstant;
import com.service.ShopService;
import com.service.TypesService;
import com.util.CaptchaUtil;
import com.util.QiniuUtils;
import com.vo.Result;
import com.constant.CommonConstant;
import com.entity.Good;
import com.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月17日 16:24
 */
@RestController
@RequestMapping("/shop/good")
@CrossOrigin
@Slf4j
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private TypesService typesService;

    /**
    * TODO 分页查询
    * @author: LZP
    * @date: 2022/8/19 10:15
    * @param pageNo:
    * @param pageSize:
    * @param req:
    * @return: com.vo.Result<?>
    */
    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {
        Page<Good> page = new Page<>(pageNo, pageSize);
        IPage<Good> pageList = goodService.page(page, new LambdaQueryWrapper<Good>()
                .eq(Good::getDelFlag, CommonConstant.DEL_FLAG_0));
        return Result.OK(pageList);
    }

    /**
    * TODO 添加
    * @author: LZP
    * @date: 2022/8/19 10:16
    * @param good:
    * @return: com.vo.Result<?>
    */
    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody Good good){
        goodService.errorCheck(good);
        good.setDelFlag(CommonConstant.DEL_FLAG_0);
        if (good.getNo()==null) {
            good.setNo(CommonConstant.GOOD_NO + new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()));
        }
        if(shopService.check(good.getShopId()) && typesService.check(good.getType())){
            good.setNum(0);
            goodService.save(good);
            return Result.OK("商品添加成功");
        }
        return Result.error("商品添加失败");
    }

    /**
    * TODO 编辑-偷偷摸摸写代码
    * @author: LZP
    * @date: 2022/8/19 11:09
    * @param good:
    * @return: com.vo.Result<?>
    */
    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody Good good){
        goodService.check(good.getId());
        goodService.updateById(good);
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    /**
    * TODO 根据id删除
    * @author: LZP
    * @date: 2022/8/19 11:10
    * @param id:
    * @return: com.vo.Result<?>
    */
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name="id") String id) {
        if(goodService.removeById(id)){
            return Result.OK(CommonConstant.DELETE_SUCCESS);
        }else {
            return Result.OK(ErrorConstant.NOT_FOUND_DATA);
        }
    }
}
