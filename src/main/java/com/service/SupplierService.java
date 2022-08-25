package com.service;

import com.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vo.param.IdsParam;

/**
* @author LBJ
* @description 针对表【west_supplier】的数据库操作Service
* @createDate 2022-08-25 21:16:24
*/
public interface SupplierService extends IService<Supplier> {

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/25 22:39
    * @param ids: 
    * @return: void
    */
    void addGoods(IdsParam ids);

    /**
    * TODO
    * @author: LZP
    * @date: 2022/8/25 23:34
    * @param ids: 
    * @return: void
    */
    void updateGoods(IdsParam ids);
}
