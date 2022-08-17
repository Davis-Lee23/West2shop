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
 *
 * @author: LZP
 * @date: 2022/8/17 16:00
 * @return:
 */
@TableName(value = "west_good")
@Data
public class Good implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     *
     */
    private String shopId;

    /**
     *
     */
    private String no;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String type;

    /**
     *
     */
    private BigDecimal price;

    /**
     *
     */
    private Integer preStock;

    /**
     *
     */
    private Integer stock;

    /**
     *
     */
    private String pic;

    /**
     *
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}