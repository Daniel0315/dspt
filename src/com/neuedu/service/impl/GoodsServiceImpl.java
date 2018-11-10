package com.neuedu.service.impl;

import com.neuedu.dao.GoodsDao;
import com.neuedu.dao.TypeDao;
import com.neuedu.dao.impl.GoodsDaoImpl;
import com.neuedu.dao.impl.TypeDaoImpl;
import com.neuedu.entity.Goods;
import com.neuedu.entity.Type;
import com.neuedu.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    @Override
    public List<Goods> listGoods(Integer offset, Integer num) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        TypeDao typeDao=new TypeDaoImpl();
        List<Goods> goodsList=goodsDao.listGoods(offset,num);
        List<Type> typeList=typeDao.listType();
        for (Goods goods : goodsList) {
            for (Type type :typeList ) {
                if (goods.getCid().equals(type.getTid())){
                    goods.setType(type);
                }
            }
        }
        return goodsList;
    }

    @Override
    public int sumCount() {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.sumCount();
    }

    @Override
    public int deletegoods(Integer gid) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.deletegoods(gid);
    }

    @Override
    public Goods findByGid(Integer gid) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.findByGid(gid);
    }

    @Override
    public int updateGoodsByGid(Goods goods) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.updateGoodsByGid(goods);
    }

    @Override
    public List<Goods> SelectGoodsByGname(String gname) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        return goodsDao.SelectGoodsByGname(gname);
    }
}
