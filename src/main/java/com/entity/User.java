package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
* TODO 公司摸鱼写代码
* @author: LZP
* @date: 2022/8/18 17:12
* @return:
*/
@TableName(value ="west_user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

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
    private String headImg;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}