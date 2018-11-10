package com.neuedu.dao.impl;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.Order;
import com.neuedu.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> listOrder(Integer offset,Integer num) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Order> ordersList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from ordertable where oifreturn=0 or oifmoney=0 limit ?,?");
            pstm.setInt(1,offset);
            pstm.setInt(2,num);
            res = pstm.executeQuery();
            while (res.next()) {
                ordersList.add(new Order(res.getInt("oid"),res.getString("onum"),
                        res.getInt("uid"),res.getInt("gid"),res.getInt("gnum"),
                        res.getTimestamp("ocreatedate"),res.getInt("oifpay"),
                        res.getTimestamp("paydate"),res.getInt("oifdelivery"),
                        res.getTimestamp("deliverydate"),res.getInt("oiffinish"),
                        res.getTimestamp("finishdate"),res.getInt("oifreturnorder"),
                        res.getInt("oifreturn"),res.getInt("oifmoney"),
                        res.getTimestamp("oifreturndate")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                JDBCUtils.close(res, pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ordersList;
    }


    @Override
    public int orderCount() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Order> ordersList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from ordertable where oifreturn=0 or oifmoney=0");
            res = pstm.executeQuery();
            while (res.next()) {
                ordersList.add(new Order(res.getInt("oid"),res.getString("onum"),
                        res.getInt("uid"),res.getInt("gid"),res.getInt("gnum"),
                        res.getTimestamp("ocreatedate"),res.getInt("oifpay"),
                        res.getTimestamp("paydate"),res.getInt("oifdelivery"),
                        res.getTimestamp("deliverydate"),res.getInt("oiffinish"),
                        res.getTimestamp("finishdate"),res.getInt("oifreturnorder"),
                        res.getInt("oifreturn"),res.getInt("oifmoney"),
                        res.getTimestamp("oifreturndate")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                JDBCUtils.close(res, pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ordersList.size();
    }

    @Override
    public int deleteOrder(String uname) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("update ordertable set oifreturn=1,oiffinish=1,oifmoney=1 where onum=?");
            pstm.setString(1,uname);
            i = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }
}
