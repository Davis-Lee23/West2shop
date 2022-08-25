package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * TODO
 *
 * @author: LZP
 * @date: 2022/8/17 16:00
 * @return:
 */
@TableName(value = "west_shop")
@Data
public class Shop implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     *
     */
    private String userId;

    /**
     *
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String pic;

    /**
     *
     */
    private String position;

    /**
     *
     */
    private Integer delFlag;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}