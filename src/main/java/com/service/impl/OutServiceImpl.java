package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.constant.ErrorConstant;
import com.dto.DataDTO;
import com.entity.Good;
import com.entity.Into;
import com.entity.Out;
import com.entity.OutDetail;
import com.mapper.GoodMapper;
import com.mapper.OutDetailMapper;
import com.service.OutService;
import com.mapper.OutMapper;
import com.vo.OutDataVO;
import com.vo.OutDetailVO;
import com.vo.OutTotalVO;
import com.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @author admin
* @description 针对表【west_out】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class OutServiceImpl extends ServiceImpl<OutMapper, Out>
    implements OutService{

    @Resource
    private GoodMapper goodMapper;
    @Resource
    private OutDetailMapper outDetailMapper;
    @Resource
    private OutMapper outMapper;

    @Override
    public void getOutDetail(List<Out> records) {
            for (Out out : records) {
                //获得所有附表数据
                List<OutDetail> detailList = outDetailMapper.selectList(new LambdaQueryWrapper<OutDetail>()
                        .eq(OutDetail::getOutId, out.getId()));
                List<OutDetailVO> voList = out.getVoList();
                BigDecimal total = new BigDecimal(0);
                //将子表数据转化为vo
                for (OutDetail outDetail : detailList) {
                    Good good = goodMapper.selectById(outDetail.getGoodId());
                    BigDecimal temp = good.getPrice().multiply(BigDecimal.valueOf(outDetail.getNum()));
                    total = total.add(temp);
                    OutDetailVO vo = transferVo(good, outDetail);
                    voList.add(vo);
                }
                out.setTotalPrice(total);
            }
        }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addByData(OutDataVO outData) {
        //主表
        Out out = new Out();
        Date now = new Date();
        out.setCreateTime(now);
        out.setUpdateTime(now);
        out.setDelFlag(CommonConstant.DEL_FLAG_0);
        out.setNo(CommonConstant.OUT_NO + new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()));
        out.setShopId(outData.getShopId());
        outMapper.insert(out);
        //子表
        for(DataDTO entity:outData.getOutDetailList()){
            OutDetail detail = new OutDetail();
            detail.setOutId(out.getId());
            detail.setGoodId(entity.getGoodId());
            detail.setNum(entity.getNum());
            detail.setCreateTime(now);
            detail.setUpdateTime(now);
            detail.setShopId(out.getShopId());
            outDetailMapper.insert(detail);
            //对商品表进行处理
            Good good = goodMapper.selectOne(new LambdaQueryWrapper<Good>().eq(Good::getId,detail.getGoodId()));
            good.setNum(good.getNum()-detail.getNum());
            if (good.getNum() < 0){
                throw new RuntimeException(ErrorConstant.GOOD_STOCK_INSUFFICIENT);
            }
            goodMapper.updateById(good);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMain(Out out, List<OutDetail> outDetailList) {
        Date now = new Date();
        out.setUpdateTime(now);
        outMapper.updateById(out);

        //1.先删除子表数据
        outDetailMapper.deleteByMainId(out.getId());

        //子表数据重新插入
        if(outDetailList != null && outDetailList.size() >0){
            for(OutDetail entity:outDetailList){
                //伪外键设置
                entity.setOutId(out.getId());
                entity.setUpdateTime(now);
                outDetailMapper.insert(entity);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delMain(String id) {
        outDetailMapper.deleteByMainId(id);
        outMapper.deleteById(id);
    }

    @Override
    public Object totalIncome(String shopId) {
        OutTotalVO vo = new OutTotalVO();
        BigDecimal result = new BigDecimal(0);
        List<Integer> list = outDetailMapper.selectOutsSum(shopId);
        try {
            List<OutDetail> outDetails = outDetailMapper.selectList(new LambdaQueryWrapper<OutDetail>()
                    .eq(OutDetail::getShopId, shopId));
            for (OutDetail outDetail : outDetails) {
                Good good = goodMapper.selectById(outDetail.getGoodId());
                if (good == null) {
                    return Result.error(ErrorConstant.GOOD_NOT_FOUND);
                }
                result = result.add(good.getPrice().multiply(BigDecimal.valueOf(outDetail.getNum())));
            }
        }catch (Exception e){
            return Result.error("统计所有收入额发生错误");
        }
        vo.setTotalPrice(result);
        vo.setTotalOrderNum(list.size());
        return vo;
    }

    public OutDetailVO transferVo(Good good,OutDetail detail){
        OutDetailVO vo = new OutDetailVO();
        BeanUtils.copyProperties(good,vo);
        vo.setGoodId(vo.getId());
        vo.setId(detail.getId());
        vo.setNum(detail.getNum());
        return vo;
    }

/*    @Override
    public String uploadImg(MultipartFile file) {
        String fileName = UUID.randomUUID() + "." + StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
        boolean upload = qiniuUtils.upload(file, fileName);
        if (upload){
            return QiniuUtils.URL + fileName;
        }
        return "上传失败";
    }

    @Override
    public void completeData(OutDataVO outData) {
        //修改主表
        Date date = new Date();
        Out out = new Out();
        out.setId(outData.getId());
        out.setDelFlag(CommonConstant.DEL_FLAG_0);
        out.setNo(CommonConstant.OUT_NO + new SimpleDateFormat("yyyyMMddHHmmssSS").format(date));
        out.setUpdateTime(date);
        outMapper.updateById(out);
        //新增附表
        for(DataDTO entity:outData.getData()){
            OutDetail detail = new OutDetail();
            detail.setOutId(out.getId());
            detail.setGoodId(entity.getId());
            detail.setNum(entity.getNum());
            detail.setUpdateTime(date);
            outDetailMapper.insert(detail);
        }
    }*/
}




