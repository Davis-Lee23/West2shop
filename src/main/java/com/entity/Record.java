package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * TODO
 * @author: LZP
 * @date: 2022/8/17 16:00
 * @return:
 */
@TableName(value ="west_record")
@Data
public class Record implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 
     */
    private String no;

    /**
     * 
     */
    private String goodId;

    /**
     * 
     */
    private Integer number;

    /**
     * 
     */
    private BigDecimal price;

    /**
     * 
     */
    private String operationId;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Integer realNum;

    /**
     * 
     */
    private Integer preNum;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}