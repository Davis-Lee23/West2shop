package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.ErrorConstant;
import com.entity.Into;
import com.entity.IntoDetail;
import com.entity.Supplier;
import com.mapper.GoodMapper;
import com.mapper.SupplierMapper;
import com.service.IntoDetailService;
import com.mapper.IntoDetailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author admin
* @description 针对表【west_into_details】的数据库操作Service实现
* @createDate 2022-08-17 15:58:04
*/
@Service
public class IntoDetailServiceImpl extends ServiceImpl<IntoDetailMapper, IntoDetail> implements IntoDetailService{

    @Resource
    private IntoDetailMapper intoDetailMapper;
    @Resource
    private GoodMapper goodMapper;
    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public void getIntoDetail(List<Into> records) {
        try {
            for (Into entity : records) {
                Supplier supplier = supplierMapper.selectById(entity.getSupplierId());
                if (supplier != null){
                    entity.setSupplierName(supplier.getName());
                }
                List<IntoDetail> list = intoDetailMapper.selectList(new LambdaQueryWrapper<IntoDetail>()
                        .eq(IntoDetail::getIntoId, entity.getId()));
                entity.setIntoDetailList(list);
                //返回更详细的Vo
                if (list != null) {
                    for(IntoDetail detail:list){
                        detail.setName(goodMapper.selectById(detail.getGoodId()).getName());
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(ErrorConstant.INTO_QUERY_ERROR);
        }
    }
}




