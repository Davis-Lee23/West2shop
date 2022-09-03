package com.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年09月03日 11:31
 */
@Data
public class OutTotalVO {

    private BigDecimal totalPrice;
    private Integer totalOrderNum;
}
