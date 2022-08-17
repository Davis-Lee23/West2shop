package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName west_types
 */
@TableName(value ="west_types")
@Data
public class Types implements Serializable {
    /**
     * 
     */
    @TableId
    private String name;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String link;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}