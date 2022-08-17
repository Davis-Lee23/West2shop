package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Record;
import com.service.RecordService;
import com.mapper.RecordMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【west_record】的数据库操作Service实现
* @createDate 2022-08-17 14:26:26
*/
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
    implements RecordService{

}




