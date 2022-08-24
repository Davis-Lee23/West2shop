package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.entity.Good;
import com.entity.Into;
import com.entity.IntoDetail;
import com.mapper.GoodMapper;
import com.mapper.IntoDetailMapper;
import com.service.IntoService;
import com.mapper.IntoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @author admin
* @description 针对表【west_into】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class IntoServiceImpl extends ServiceImpl<IntoMapper, Into> implements IntoService{

    @Resource
    private IntoMapper intoMapper;
    @Resource
    private GoodMapper goodMapper;
    @Resource
    private IntoDetailMapper intoDetailMapper;

    @Override
    public void savaMain(Into into, List<IntoDetail> intoDetailList) {
        into.setNo(CommonConstant.IN_ORDER_NO + new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()));
        into.setDelFlag(CommonConstant.DEL_FLAG_0);
        //添加入库信息
        intoMapper.insert(into);
        Date now = new Date();
        if(intoDetailList != null && intoDetailList.size()>0){
            for(IntoDetail entity:intoDetailList){
                Good good = goodMapper.selectById(entity.getGoodId());
                //原本不存在该商品
                if(good == null){
                    good = new Good();
                    good.setId(entity.getGoodId());
                    good.setName(entity.getName());
                    good.setPrice(entity.getPrice());
                    good.setStock(entity.getNumber());
                    good.setDelFlag(CommonConstant.DEL_FLAG_0);
                    //往商品基本信息添加数据
                    goodMapper.insert(good);
                    entity.setGoodId(good.getId());
                }else {
                    //原本存在商品
                    good.setStock(good.getStock()+entity.getNumber());
                    goodMapper.updateById(good);
                }
                //往详情表添加商品
                entity.setCreateTime(now);
                entity.setIntoId(into.getId());
                intoDetailMapper.insert(entity);
            }
        }
    }

    @Override
    public void updateMain(Into into, List<IntoDetail> intoDetailList) {
        into.setUpdateTime(new Date());
        intoMapper.updateById(into);

        //1.先删除子表数据
        intoDetailMapper.deleteByMainId(into.getId());

        //2.子表数据重新插入
        Date date = new Date();
        if (intoDetailList != null && intoDetailList.size() > 0) {
            for (IntoDetail entity : intoDetailList) {
                //伪外键设置
                entity.setIntoId(into.getId());
                entity.setCreateTime(date);
                intoDetailMapper.insert(entity);
            }
        }
    }

    @Override
    public void delMain(String id) {
        intoDetailMapper.deleteByMainId(id);
        intoMapper.deleteById(id);
    }
}




