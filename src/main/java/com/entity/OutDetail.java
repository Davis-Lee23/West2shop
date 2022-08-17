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
@TableName(value ="west_out_detail")
@Data
public class OutDetail implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 
     */
    private String goodId;

    /**
     * 
     */
    private Integer number;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}