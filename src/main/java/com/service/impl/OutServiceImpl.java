package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.dto.DataDTO;
import com.entity.Good;
import com.entity.Out;
import com.entity.OutDetail;
import com.mapper.GoodMapper;
import com.mapper.OutDetailMapper;
import com.service.OutService;
import com.mapper.OutMapper;
import com.util.QiniuUtils;
import com.vo.OutDataVO;
import com.vo.OutDetailVO;
import com.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private QiniuUtils qiniuUtils;
    @Resource
    private OutMapper outMapper;

    @Override
    public void getOutDetail(List<Out> records) {
            for (Out out : records) {
                List<OutDetail> detailList = outDetailMapper.selectList(new LambdaQueryWrapper<OutDetail>()
                        .eq(OutDetail::getOutId, out.getId()));
                List<OutDetailVO> voList = out.getVoList();
                //将子表数据转化为vo
                for (OutDetail outDetail : detailList) {
                    Good good = goodMapper.selectById(outDetail.getGoodId());
                    OutDetailVO vo = transferVo(good, outDetail);
                    voList.add(vo);
                }
            }
        }

    public OutDetailVO transferVo(Good good,OutDetail detail){
        OutDetailVO vo = new OutDetailVO();
        BeanUtils.copyProperties(good,vo);
        vo.setGoodId(vo.getId());
        vo.setId(detail.getId());
        vo.setNum(detail.getNum());
        return vo;
    }

    @Override
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
    }
}




