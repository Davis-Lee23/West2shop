package com.service;

import com.entity.Types;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author admin
 * @description 针对表【west_types】的数据库操作Service
 * @createDate 2022-08-17 16:07:37
 */
public interface TypesService extends IService<Types> {

    /**
    * TODO 分类递归展示
    * @author: LZP
    * @date: 2022/8/19 8:44
    * @return:
    */
    List<Types> listWithTree();
}
