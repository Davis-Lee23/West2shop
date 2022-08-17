package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Types;
import com.service.TypesService;
import com.mapper.TypesMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【west_types】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class TypesServiceImpl extends ServiceImpl<TypesMapper, Types>
    implements TypesService{

}




