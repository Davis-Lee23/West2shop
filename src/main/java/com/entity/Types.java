package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * TODO
 * @author: LZP
 * @date: 2022/8/17 16:00
 * @return:
 */
@TableName(value ="west_types")
@Data
public class Types implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
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