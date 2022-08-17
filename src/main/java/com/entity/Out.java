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
 * @TableName west_out
 */
@TableName(value ="west_out")
@Data
public class Out implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String no;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}