package com.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName west_user
 */
@TableName(value ="west_user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId
    private String phone;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String pwd;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String headImg;

    /**
     * 
     */
    @TableLogic(value = "0",delval = "1")
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}