package com.vo;

import com.dto.TimeGoodDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月24日 16:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotVo {

    private List<TimeGoodDTO> list;
    private Integer sum;
}
