package com.controller;

import com.util.CaptchaUtil;
import com.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.image.BufferedImage;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年09月02日 15:23
 */
@CrossOrigin
@RequestMapping("/shop/test")
public class TestController {

    @Autowired
    private CaptchaUtil captchaUtil;

    @GetMapping(value = "/pic")
    public BufferedImage pic(){
        BufferedImage image = captchaUtil.getMsg();
        return image;
    }
}
