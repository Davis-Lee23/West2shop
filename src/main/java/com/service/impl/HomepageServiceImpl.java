package com.service.impl;

import com.constant.ErrorConstant;
import com.dto.TimeGoodDTO;
import com.entity.Good;
import com.mapper.GoodMapper;
import com.mapper.OutDetailMapper;
import com.service.HomepageService;
import com.vo.HotGoodVO;
import com.vo.TimeSlotVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description: TODO 主页
 * @author: LZP
 * @date: 2022年08月24日 15:43
 */

@Service
public class HomepageServiceImpl implements HomepageService {

    @Resource
    private OutDetailMapper outDetailMapper;
    @Resource
    private GoodMapper goodMapper;

    @Override
    public List<HotGoodVO> hotGoods() {
        List<HotGoodVO> list = outDetailMapper.selectHotGoods();
        System.out.println(list);
        for(HotGoodVO vo:list){
            Good good = goodMapper.selectById(vo.getGoodId());
            if(good == null){
                throw new RuntimeException(ErrorConstant.GOOD_NOT_FOUND);
            }
            vo.setName(good.getName());
            vo.setPrice(good.getPrice());
        }
        //倒序排序
        list.sort(Comparator.comparing(HotGoodVO::getNum).reversed());
        return list;
    }

    @Override
    public List<TimeSlotVo> timeSlots() {
        List<TimeGoodDTO> beforeDown = outDetailMapper.selectByTime(0,6);
        List<TimeGoodDTO> morning = outDetailMapper.selectByTime(6,11);
        List<TimeGoodDTO> noon = outDetailMapper.selectByTime(11,13);
        List<TimeGoodDTO> afternoon = outDetailMapper.selectByTime(13,18);
        List<TimeGoodDTO> night = outDetailMapper.selectByTime(18,24);
        List<TimeSlotVo> list = new ArrayList<>();
        list.add(new TimeSlotVo(beforeDown,getTimeSum(beforeDown)));
        list.add(new TimeSlotVo(morning,getTimeSum(morning)));
        list.add(new TimeSlotVo(noon,getTimeSum(noon)));
        list.add(new TimeSlotVo(afternoon,getTimeSum(afternoon)));
        list.add(new TimeSlotVo(night,getTimeSum(night)));
        return list;
    }

    /**
    * TODO 返回总数，同时完善数据
    * @author: LZP
    * @date: 2022/8/24 17:36
    * @param list:
    * @return: java.lang.Integer
    */
    private Integer getTimeSum(List<TimeGoodDTO> list) {
        Integer sum = 0;
        try {
            for (TimeGoodDTO dto : list) {
                //商品查询错误
                Good temp = goodMapper.selectById(dto.getGoodId());
                sum += dto.getNum();
                dto.setName(temp.getName());
                dto.setPrice(temp.getPrice());
            }
            list.sort(Comparator.comparing(TimeGoodDTO::getNum).reversed());
        }catch (Exception e){
            throw new RuntimeException("统计错误，请联系管理员");
        }
        return sum;
    }
}
