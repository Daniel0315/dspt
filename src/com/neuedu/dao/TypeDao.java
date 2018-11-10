package com.neuedu.dao;

import com.neuedu.entity.Type;

import java.util.List;

public interface TypeDao {

    /**
     * 查询全部商品类型
     * @return
     */
    List<Type> listType();

    /**
     * 根据类型名称获取tid;
     * @param tname
     * @return
     */
    Type listTypeByTname(String tname);
}
