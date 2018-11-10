package com.neuedu.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuery {
    public static List<Object> query(String sql,ResultSetObject result,Object ...objs)  {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Object> objectList=new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement(sql);
            JDBCUtils.insertData(pstm,objs);
            res= pstm.executeQuery();
            while (res.next()){
                Object obj=result.getByResultSet(res);
                objectList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.close(res,pstm,conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return objectList;
    }
}
