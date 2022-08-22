package com.vo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO 前端奇葩商品json
 * @author: LZP
 * @date: 2022年08月20日 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodParam {

    private String id;
    private String name;
    private Integer num;

}
