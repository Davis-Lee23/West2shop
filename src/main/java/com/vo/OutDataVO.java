package com.vo;

import com.dto.DataDTO;
import com.entity.Good;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月23日 16:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutDataVO {
    private String id;
    private List<DataDTO> data;
}
