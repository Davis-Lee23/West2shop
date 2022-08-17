package com.west2shop;

import com.entity.Good;
import com.mapper.GoodMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class West2ShopApplicationTests {

    @Resource
    private GoodMapper goodMapper;

    @Test
    public void context(){
        List<Good> goods = goodMapper.selectList(null);
        System.out.println("列表："+goods);
    }
}
