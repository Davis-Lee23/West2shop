package com.mapper;

import com.dto.TimeGoodDTO;
import com.entity.OutDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vo.HotGoodVO;

import java.util.List;

/**
* @author admin
* @description 针对表【west_out_detail】的数据库操作Mapper
* @createDate 2022-08-17 16:07:37
* @Entity com.entity.OutDetail
*/
public interface OutDetailMapper extends BaseMapper<OutDetail> {

    void deleteByMainId(String id);

    /**
    * TODO 热销商品
    * @author: LZP
    * @date: 2022/8/24 15:47
    * @return: java.util.List<com.vo.HotGoodVO>
    */
    List<HotGoodVO> selectHotGoods(String shopId);

    List<TimeGoodDTO> selectByTime(int start, int end,String shopId);

    /**
    * TODO 商店所有出库单
    * @author: LZP
    * @date: 2022/9/3 11:34
    * @param shopId :
    * @return: java.lang.Integer
    */
    List<Integer> selectOutsSum(String shopId);
}




