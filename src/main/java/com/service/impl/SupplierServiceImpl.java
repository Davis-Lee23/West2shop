package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.ErrorConstant;
import com.entity.Supplier;
import com.entity.SupplierGood;
import com.mapper.SupplierGoodMapper;
import com.service.SupplierService;
import com.mapper.SupplierMapper;
import com.vo.param.IdsParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author LBJ
* @description 针对表【west_supplier】的数据库操作Service实现
* @createDate 2022-08-25 21:16:24
*/
@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier>
    implements SupplierService{

    @Resource
    private SupplierGoodMapper supplierGoodMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addGoods(IdsParam ids) {
        if(StringUtils.isEmpty(ids.getIds())){
            throw new RuntimeException(ErrorConstant.ID_IZ_NULL);
        }
        List<String> list = Arrays.asList(ids.getIds().split(","));
        String supplierId = ids.getSupplierId();
        Date now = new Date();
        for(String id:list){
            SupplierGood entity = new SupplierGood(id,supplierId,now,now);
            supplierGoodMapper.insert(entity);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGoods(IdsParam ids) {
        //删除原有数据
        supplierGoodMapper.delete(null);
        if(ids != null && ids.getIds().equals("")){
            return;
        }
        addGoods(ids);
    }
}




