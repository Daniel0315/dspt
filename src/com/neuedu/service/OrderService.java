package com.neuedu.service;

import com.neuedu.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * 查询所有订单
     * @return
     */
    List<Order> listOrder(Integer offset,Integer num);

    /**
     * 查询订单的数量
     */
    int orderCount();

    /**
     * 根据账号删除订单
     */
    int deleteOrder(String uname);

}
