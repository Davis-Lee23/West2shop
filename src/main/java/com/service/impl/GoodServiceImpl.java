package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Good;
import com.service.GoodService;
import com.mapper.GoodMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【west_good】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good>
    implements GoodService{

}




