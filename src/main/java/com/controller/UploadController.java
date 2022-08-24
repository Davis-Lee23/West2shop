package com.controller;

import com.util.QiniuUtils;
import com.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description: TODO 图片上传
 * @author: LZP
 * @date: 2022年08月23日 15:19
 */
@RestController
@RequestMapping("/shop/upload")
@CrossOrigin
public class UploadController {

    @Resource
    private QiniuUtils qiniuUtils;

    @PostMapping(value = "/image")
    public Result<?> upload(@RequestParam("image") MultipartFile file){
        String url = qiniuUtils.uploadImg(file);
        return Result.OK(url);
    }
}
