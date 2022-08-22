package com.west2shop;

import com.entity.Out;
import com.mapper.GoodMapper;
import com.mapper.OutMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class West2ShopApplicationTests {

    @Resource
    private GoodMapper goodMapper;
    @Resource
    private OutMapper outMapper;

    @Test
    public void context(){
        List<Out> goods = outMapper.selectList(null);
        System.out.println("列表:"+goods);
    }
}
