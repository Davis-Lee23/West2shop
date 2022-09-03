package com.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.entity.User;
import com.service.UserService;
import com.util.CaptchaUtil;
import com.vo.Result;
import com.vo.param.LoginParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月24日 11:17
 */
@RestController
@RequestMapping("/shop/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CaptchaUtil captchaUtil;

    @GetMapping(value = "/list")
    public Result<?> queryPageList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                   HttpServletRequest req) {
        Page<User> userPage = new Page<>(pageNo, pageSize);
        IPage<User> pageList = userService.page(userPage);
        return Result.OK(pageList);
    }

    @PostMapping(value = "/add")
    public Result<?> add(@RequestBody User user) {
        if (userService.getById(user.getPhone()) != null) {
            return Result.error(ErrorConstant.DUPLICATE_DATA);
        }
        user.setDelFlag(CommonConstant.DEL_FLAG_0);
        //md5加盐加密
        user.setPwd(SaSecureUtil.md5BySalt(user.getPwd(), CommonConstant.SALT));
        userService.save(user);
        return Result.OK(user);
    }

    @PutMapping(value = "/edit")
    public Result<?> edit(@RequestBody User user) {
        //密码MD5加密
        user.setPwd(SaSecureUtil.md5BySalt(user.getPwd(),CommonConstant.SALT));
        userService.updateById(user);
        return Result.OK(user);
    }

    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "phone") String phone) {
        userService.removeById(phone);
        return Result.OK(CommonConstant.DELETE_SUCCESS);
    }

    @PostMapping(value = "/doLogin")
    public Result<?> doLogin(@RequestBody LoginParam loginParam) {
        if (loginParam == null || StringUtils.isEmpty(loginParam.getPhone()) || StringUtils.isEmpty(loginParam.getPwd()) || StringUtils.isEmpty(loginParam.getCaptcha())) {
            return Result.error(ErrorConstant.IZ_NULL);
        }
        return userService.doLogin(loginParam);
    }

    @GetMapping(value = "/getCaptcha")
    public void pic(HttpServletResponse response) {
        response.setContentType("image/png");
        try {
            BufferedImage image = captchaUtil.getMsg();
            ImageIO.write(image, "PNG", response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
