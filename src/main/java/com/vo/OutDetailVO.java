package com.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月23日 16:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutDetailVO {

    private String id;

    private String goodId;

    private String name;

    private BigDecimal price;

    private Integer num;
}
