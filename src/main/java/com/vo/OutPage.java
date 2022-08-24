package com.vo;

import com.entity.OutDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月24日 10:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutPage {
    private String id;

    /**
     *
     */
    private String no;

    /**
     *
     */
    private String shopId;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private List<OutDetail> outDetailList;
}
