package com.neuedu.dao.impl;

import com.neuedu.dao.TypeDao;
import com.neuedu.entity.Type;
import com.neuedu.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    @Override
    public List<Type> listType() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Type> typeList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from type");
            res = pstm.executeQuery();
            while (res.next()) {
                typeList.add(new Type(res.getInt("tid"),res.getString("tname")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(res, pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return typeList;
    }

    @Override
    public Type listTypeByTname(String tname) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Type type=new Type();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from type where tname=?");
            pstm.setString(1,tname);
            res = pstm.executeQuery();
            while (res.next()) {
                type=new Type(res.getInt("tid"),res.getString("tname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(res, pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return type;
    }


}
