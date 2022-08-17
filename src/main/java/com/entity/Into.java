package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName west_into
 */
@TableName(value ="west_into")
@Data
public class Into implements Serializable {
    /**
     * 
     */
    @TableId
    private String id;

    /**
     * 
     */
    private String goodId;

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
    private String type;

    /**
     * 
     */
    private Integer number;

    /**
     * 
     */
    private Integer price;

    /**
     * 
     */
    private String supplier;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date time;

    /**
     * 
     */
    private String comment;

    /**
     * 
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}