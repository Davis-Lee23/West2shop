package com.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.entity.User;
import com.service.UserService;
import com.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月24日 11:17
 */
@RestController
@RequestMapping("/shop/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req){
        Page<User> userPage = new Page<>(pageNo,pageSize);
        IPage<User> pageList = userService.page(userPage,new LambdaQueryWrapper<User>()
                .eq(User::getDelFlag, CommonConstant.DEL_FLAG_0));
        return Result.OK(pageList);
    }

    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody User user){
        if(userService.list(new LambdaQueryWrapper<User>().
                eq(User::getName,user.getName())) !=null){
           return Result.OK("用户名重复");
        }
        user.setDelFlag(CommonConstant.DEL_FLAG_0);
        //md5加盐加密
        user.setPwd(SaSecureUtil.md5BySalt(user.getPwd(),CommonConstant.SALT));
        userService.save(user);
        return Result.OK(user);
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody User user){
        userService.updateById(user);
        return Result.OK(CommonConstant.EDIT_SUCCESS);
    }

    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id") String id){
        userService.removeById(id);
        return Result.OK(CommonConstant.DELETE_SUCCESS);
    }

    @RequestMapping(value = "/doLogin")
    public SaResult doLogin(String name,String pwd){

        return null;
    }

}
