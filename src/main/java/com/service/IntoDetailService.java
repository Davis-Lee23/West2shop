package com.service;

import com.entity.Into;
import com.entity.IntoDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author admin
 * @description 针对表【west_into_details】的数据库操作Service
 * @createDate 2022-08-17 15:58:04
 */
public interface IntoDetailService extends IService<IntoDetail> {

    /**
    * TODO 获取附表数据
    * @author: LZP
    * @date: 2022/8/22 16:09
    * @param records:
    * @return: void
    */
    void getIntoDetail(List<Into> records);
}
