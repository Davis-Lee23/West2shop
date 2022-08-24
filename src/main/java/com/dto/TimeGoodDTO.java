package com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月24日 17:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeGoodDTO {

    private String goodId;
    private Integer num;
    private String name;
    private BigDecimal price;

}
