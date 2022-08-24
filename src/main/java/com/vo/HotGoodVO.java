package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月24日 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotGoodVO {

    private String goodId;
    private Integer num;
    private String name;
    private BigDecimal price;
}
