package com.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.entity.IntoDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月20日 10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntoPage {
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
    private String supplier;

    /**
     *
     */
    private Integer status;

    /**
     *
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     *
     */
    private String comment;

    /**
     *
     */
    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    private List<IntoDetail> intoDetailList;
}
