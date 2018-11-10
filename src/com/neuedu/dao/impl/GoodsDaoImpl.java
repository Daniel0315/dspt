package com.neuedu.dao.impl;

import com.neuedu.dao.GoodsDao;
import com.neuedu.entity.Goods;
import com.neuedu.entity.User;
import com.neuedu.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {


    @Override
    public List<Goods> listGname() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Goods> goodsList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from goods where ifdelete=0");
            res = pstm.executeQuery();
            while (res.next()) {
                goodsList.add(new Goods(res.getInt("gid"),res.getString("gname"),
                        res.getDouble("gprice"),res.getInt("grepertory"),
                        res.getInt("gsalesvolume"),res.getString("gstandard"),
                        res.getString("gimg"),res.getString("gremarks"),
                        res.getInt("cid")));
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
        return goodsList;
    }

    @Override
    public int insertGoods(Goods goods) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("insert into goods (gname,gprice,grepertory,gstandard,gimg,gremarks,cid,gsalesvolume) values (?,?,?,?,?,?,?,?)");
            pstm.setString(1,goods.getGname());
            pstm.setDouble(2,goods.getGprice());
            pstm.setInt(3,goods.getGrepertory());
            pstm.setString(4,goods.getGstandard());
            pstm.setString(5,goods.getGimg());
            pstm.setString(6,goods.getGremarks());
            pstm.setInt(7,goods.getCid());
            pstm.setInt(8,goods.getGsalesvolume());

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

    @Override
    public List<Goods> listGoods(Integer offset,Integer num) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Goods> goodsList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from goods where ifdelete=0 limit ?,?");
            pstm.setInt(1, offset);
            pstm.setInt(2, num);
            res = pstm.executeQuery();
            while (res.next()) {
               goodsList.add(new Goods(res.getInt("gid"),res.getString("gname"),
                       res.getDouble("gprice"),res.getInt("grepertory"),
                       res.getInt("gsalesvolume"),res.getString("gstandard"),
                       res.getString("gimg"),res.getString("gremarks"),
                       res.getInt("cid")));
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
        return goodsList;
    }

    @Override
    public int sumCount() {
        GoodsDao goodsDao=new GoodsDaoImpl();
       return goodsDao.listGname().size();
    }

    @Override
    public int deletegoods(Integer gid) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("update goods set ifdelete=1 where gid=?");
            pstm.setInt(1,gid);
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

    @Override
    public Goods findByGid(Integer gid) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Goods goods=new Goods();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from goods where gid=?");
            pstm.setInt(1, gid);
            res = pstm.executeQuery();
            while (res.next()) {
                goods=new Goods(res.getInt("gid"),res.getString("gname"),
                        res.getDouble("gprice"),res.getInt("grepertory"),
                        res.getInt("gsalesvolume"),res.getString("gstandard"),
                        res.getString("gimg"),res.getString("gremarks"),
                        res.getInt("cid"));
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
        return goods;
    }

    @Override
    public int updateGoodsByGid(Goods goods) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("update goods set gname=?,gprice=?,grepertory=?,gstandard=?,gimg=?,gremarks=?,cid=?,gsalesvolume=? where gid=?");
            pstm.setString(1,goods.getGname());
            pstm.setDouble(2,goods.getGprice());
            pstm.setInt(3,goods.getGrepertory());
            pstm.setString(4,goods.getGstandard());
            pstm.setString(5,goods.getGimg());
            pstm.setString(6,goods.getGremarks());
            pstm.setInt(7,goods.getCid());
            pstm.setInt(8,goods.getGsalesvolume());
            pstm.setInt(9,goods.getGid());
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

    @Override
    public List<Goods> SelectGoodsByGname(String gname) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        List<Goods> goodsList=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            pstm=conn.prepareStatement("select * from goods where gname like CONCAT('%',?,'%')");
            pstm.setString(1,gname);
            res=pstm.executeQuery();
            while (res.next()){
                goodsList.add(new Goods(res.getInt("gid"),res.getString("gname"),
                        res.getDouble("gprice"),res.getInt("grepertory"),
                        res.getInt("gsalesvolume"),res.getString("gstandard"),
                        res.getString("gimg"),res.getString("gremarks"),
                        res.getInt("cid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                JDBCUtils.close(pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return goodsList;
    }


}
