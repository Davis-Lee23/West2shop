package com.mapper;

import com.entity.IntoDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author admin
* @description 针对表【west_into_details】的数据库操作Mapper
* @createDate 2022-08-17 15:58:04
* @Entity com.entity.IntoDetail
*/
public interface IntoDetailMapper extends BaseMapper<IntoDetail> {

    void deleteByMainId(String id);
}




