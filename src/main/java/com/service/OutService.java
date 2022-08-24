package com.service;

import com.entity.Out;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.OutDetail;
import com.vo.OutDataVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author admin
 * @description 针对表【west_out】的数据库操作Service
 * @createDate 2022-08-17 16:07:37
 */
public interface OutService extends IService<Out> {

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/23 16:23
    * @param records: 
    * @return: void
    */
    void getOutDetail(List<Out> records);

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/24 10:07
    * @param data: 
    * @return: void
    */
    void addByData(OutDataVO data);

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/24 10:27
    * @param out: 
    * @param outDetailList: 
    * @return: void
    */
    void updateMain(Out out, List<OutDetail> outDetailList);

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/24 10:39
    * @param id:
    * @return: void
    */
    void delMain(String id);

//    /**
//    * TODO
//    * @author: LZP
//    * @date: 2022/8/23 16:40
//    * @param file:
//    * @return: void
//    */
//    String uploadImg(MultipartFile file);
//
//    /**
//    * TODO
//    * @author: LZP
//    * @date: 2022/8/23 17:26
//    * @param outData:
//    * @return: void
//    */
//    void completeData(OutDataVO outData);
}
