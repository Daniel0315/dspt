package com.neuedu.service.impl;

import com.neuedu.dao.GoodsDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.GoodsDaoImpl;
import com.neuedu.dao.impl.OrderDaoImpl;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.Goods;
import com.neuedu.entity.Order;
import com.neuedu.entity.User;
import com.neuedu.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public List<Order> listOrder(Integer offset,Integer num) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        UserDao userDao=new UserDaoImpl();
        List<Order> orderList=orderDao.listOrder(offset, num);
        List<Goods> goodsList=goodsDao.listGname();
        List<User> userList=userDao.listUname();
        for (Order order : orderList) {
            for (Goods goods : goodsList) {
                if (goods.getGid().equals(order.getGid())){
                    order.setGoods(goods);
                }
            }
        }

        for (Order order : orderList) {
            for (User user : userList) {
                if (user.getUid().equals(order.getUid())){
                    order.setUser(user);
                }
            }
        }

        return orderList;
    }


    @Override
    public int orderCount() {
        return orderDao.orderCount();
    }

    @Override
    public int deleteOrder(String uname) {
        return orderDao.deleteOrder(uname);
    }
}
