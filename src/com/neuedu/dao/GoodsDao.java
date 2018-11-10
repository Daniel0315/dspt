package com.neuedu.dao;

import com.neuedu.entity.Goods;

import java.util.List;

public interface GoodsDao {

    /**
     * 遍历商品
     */
    List<Goods> listGname();

    /**
     * 添加商品信息
     */
    int insertGoods(Goods goods);

    /**
     *分页显示商品信息
     */
    List<Goods> listGoods(Integer offset,Integer num);

    /**
     * 查询所有商品的总数
     * @param
     * @return
     */
    int sumCount();

    /**
     * 删除商品信息
     */
    int deletegoods(Integer gid);

    /**
     * 查找一条商品的记录
     */
    Goods findByGid(Integer gid);

    /**
     * 修改商品信息
     */
    int updateGoodsByGid(Goods goods);

    /**
     * 通过商品名称查询商品信息
     * @param
     * @return
     */
    List<Goods> SelectGoodsByGname(String gname);

}
