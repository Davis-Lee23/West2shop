package com.service;

import com.vo.HotGoodVO;

import java.util.List;

public interface HomepageService {

    /**
    * TODO 热销商品
    * @author: LZP
    * @date: 2022/8/24 16:28
    * @return: java.util.List<com.vo.HotGoodVO>
    */
    List<HotGoodVO> hotGoods(String shopId);

    /**
    * TODO 时间段最热商品
    * @author: LZP
    * @date: 2022/8/24 16:28
    * @return: java.lang.Object
    */
    Object timeSlots(String shopId);
}
