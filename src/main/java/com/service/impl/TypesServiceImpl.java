package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.constant.CommonConstant;
import com.entity.Types;
import com.service.TypesService;
import com.mapper.TypesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author admin
* @description 针对表【west_types】的数据库操作Service实现
* @createDate 2022-08-17 16:07:37
*/
@Service
public class TypesServiceImpl extends ServiceImpl<TypesMapper, Types> implements TypesService{

    @Resource
    private TypesMapper typesMapper;

    @Override
    public List<Types> listWithTree() {
        List<Types> pageList = typesMapper.selectList(null);
        List<Types> types = pageList.stream().filter(type ->
                CommonConstant.TYPES_ANCESTOR.equals(type.getPid())).map((menu) ->{
                    menu.setChildren(getChildrenData(menu,pageList));
                    return menu;
        }).collect(Collectors.toList());
        return types;
    }

    /**
    * TODO 获取孩子（下级目录）的方法，递归实现
    * @author: LZP
    * @date: 2022/8/19 8:54
    * @param root:
    * @param list:
    * @return: java.util.List<com.entity.Types>
    */
    private List<Types> getChildrenData(Types root, List<Types> list){
        List<Types> children = list.stream().filter(types ->
                types.getPid().equals(root.getId())
        ).map(types -> {
            types.setChildren(getChildrenData(types,list));
            return types;
        }).collect(Collectors.toList());
        return children;
    }

    @Override
    public boolean check(String id) {
        Types types = typesMapper.selectById(id);
        //分类存在，且没有被软删除
        return types != null && types.getDelFlag().equals(CommonConstant.DEL_FLAG_0);
    }
}




