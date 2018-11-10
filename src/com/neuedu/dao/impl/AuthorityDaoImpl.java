package com.neuedu.dao.impl;

import com.neuedu.dao.AuthorityDao;
import com.neuedu.entity.Authority;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.utils.JDBCUtils;
import com.neuedu.utils.ResultSetObject;
import com.neuedu.utils.UpdateQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorityDaoImpl implements AuthorityDao {
    @Override
    public List<Authority> listAuthority(List<String> ids) {
            String sql="SELECT * from authority where ifdelete=0 and ";
            Object objs[]=new Object[ids.size()];
            for (int i = 0; i < ids.size(); i++) {
                if (i==ids.size()-1){
                    sql+="aid=?";
                }else {
                    sql+="aid=? or ";
                }
                objs[i]= ids.get(i);
            }
        List<Object> objectList=UpdateQuery.query(sql, new ResultSetObject() {
            @Override
            public Object getByResultSet(ResultSet res) throws SQLException {
                Authority authority=new Authority();
                authority=new Authority(res.getInt("aid"),res.getString("acontent"),
                        res.getInt("ifdelete"),res.getString("url"),res.getString("aphone")
                );
                return authority;
            }
        },objs);
            if (objectList==null||objectList.size()==0){
                return null;
            }
            List<Authority> authorityList=new ArrayList<>();
        for (Object o : objectList) {
            authorityList.add((Authority) o);
        }
        return authorityList;
    }

    @Override
    public List<Authority> authority() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Authority> authorityList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from authority where ifdelete=0");
            res = pstm.executeQuery();
            while (res.next()) {
                authorityList.add(new Authority(res.getInt("aid"),res.getString("acontent"),
                        res.getInt("ifdelete"),res.getString("url"),
                        res.getString("aphone")));
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
        return authorityList;
    }


}
