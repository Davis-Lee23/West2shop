package com.util;

/**
 * @Description: TODO 七牛云图片服务器工具类-动静分离
 * @author: LZP
 * @date: 2022年08月17日 8:53
 */

import com.alibaba.fastjson.JSON;
import com.constant.ErrorConstant;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
public class QiniuUtils {

    public static final String URL = "http://rgsrp6kaq.hn-bkt.clouddn.com/";

    @Value("HTZIjUGmLw3T1V52SHIVw-QsBXV5dSvNn_9ELjPi")
    private String accessKey;
    @Value("hUaPj95V8g1TCiIL5U4fjjVoBoTUxcZvs_O01rzS")
    private String accessSecretKey;

    public boolean upload(MultipartFile file, String fileName) {

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String bucket = "temp-pic-store";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            byte[] uploadBytes = file.getBytes();
            Auth auth = Auth.create(accessKey, accessSecretKey);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(uploadBytes, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String uploadImg(MultipartFile file){
        String fileName = UUID.randomUUID() + "." + StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
        boolean flag = upload(file, fileName);
        if (flag){
            return QiniuUtils.URL + fileName;
        }
        throw new RuntimeException(ErrorConstant.UTILS_UPLOAD_IMAGE_ERROR);
    }
}
