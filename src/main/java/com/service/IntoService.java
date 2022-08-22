package com.service;

import com.entity.Into;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.IntoDetail;

import java.util.List;

/**
 * @author admin
 * @description 针对表【west_into】的数据库操作Service
 * @createDate 2022-08-17 16:07:37
 */
public interface IntoService extends IService<Into> {

    /**
     * 添加一对多
     * @param into
     * @param intoDetailList
     */
    void savaMain(Into into, List<IntoDetail> intoDetailList);

    /**
     * 修改一对多
     * @param into
     * @param intoDetailList
     */
    void updateMain(Into into, List<IntoDetail> intoDetailList);

    /**
     * 删除一对多
     * @param id
     */
    void delMain(String id);
}
