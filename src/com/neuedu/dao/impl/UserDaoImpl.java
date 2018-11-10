package com.neuedu.dao.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.entity.User;
import com.neuedu.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> listUname() {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        List<User> userList=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            pstm=conn.prepareStatement("SELECT * from usertable where ifdelete=0");

            res=pstm.executeQuery();
            while (res.next()){
                userList.add(
                        new User(res.getInt("uid"),res.getString("uname"),res.getString("upwd"),res.getString("usex"),
                                res.getString("receiver"), res.getString("raddress"),
                                res.getString("rtelephone"), res.getInt("rlevel")));
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
        return userList;
    }

    @Override
    public List<User> listUser(Integer rlevel,Integer offset,Integer num) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<User> userList = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from usertable where ifdelete=0 and  rlevel=? limit ?,?");
            pstm.setInt(1, rlevel);
            pstm.setInt(2, offset);
            pstm.setInt(3, num);
            res = pstm.executeQuery();
            while (res.next()) {
                userList.add(new User(res.getInt("uid"), res.getString("uname"),
                        res.getString("upwd"), res.getString("usex"),
                        res.getDate("ubirthday"), res.getString("receiver"),
                        res.getString("raddress"), res.getString("rtelephone"),
                        res.getInt("rlevel"), res.getString("raids"),
                        res.getInt("ifdelete")));
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
            return userList;
    }

    @Override
    public int sumCount(Integer rlevel) {
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet res=null;
        List<User> userList=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            pstm=conn.prepareStatement("SELECT * from usertable where rlevel=? and ifdelete=0");
            pstm.setInt(1,rlevel);
            res=pstm.executeQuery();
            while (res.next()){
                userList.add(
                        new User(res.getInt("uid"),res.getString("uname"),res.getString("upwd"),res.getString("usex"),
                                res.getString("receiver"), res.getString("raddress"),
                                res.getString("rtelephone"), res.getInt("rlevel")));
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
        return userList.size();
    }

    @Override
    public int deleteUser(String uname) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("update usertable set ifdelete=1 where uname=?");
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

    @Override
    public List<User> listUserByUname(String uname) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res=null;
       List<User> userList=new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from usertable where ifdelete=0 and uname like CONCAT('%',?,'%')");
            pstm.setString(1,uname);
            res= pstm.executeQuery();
            while (res.next()){
                userList.add(new User(res.getInt("uid"),res.getString("uname"),
                        res.getString("upwd"),res.getString("usex"),
                        res.getDate("ubirthday"),res.getString("receiver"),
                        res.getString("raddress"), res.getString("rtelephone"),
                        res.getInt("rlevel"), res.getString("raids"),
                        res.getInt("ifdelete")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(res,pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public int updateUser(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("update usertable set usex=?,ubirthday=?,receiver=?,raddress=?,rtelephone=? where uname=?");
            pstm.setString(1,user.getUsex());
            pstm.setDate(2, user.getUbirthday());
            pstm.setString(3,user.getReceiver());
            pstm.setString(4,user.getRaddress());
            pstm.setString(5,user.getRtelephone());
            pstm.setString(6,user.getUname());
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
    public User login(String uname, String upwd) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res=null;
        User user=null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from usertable where ifdelete=0 and uname=? and upwd=?");
            pstm.setString(1,uname);
            pstm.setString(2,upwd);
            res= pstm.executeQuery();
            while (res.next()){
                user=new User(res.getInt("uid"),res.getString("uname"),
                        res.getString("upwd"),res.getString("usex"),
                        res.getDate("ubirthday"),res.getString("receiver"),
                        res.getString("raddress"), res.getString("rtelephone"),
                        res.getInt("rlevel"), res.getString("raids"),
                        res.getInt("ifdelete"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(res,pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int register(String uname,String upwd,String uemail,String uphone) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("insert into usertable (uname,upwd,uemail,uphone) values (?,?,?,?)");
            pstm.setString(1,uname);
            pstm.setString(2,upwd);
            pstm.setString(3,uemail);
            pstm.setString(4,uphone);
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
    public int distribution(String uname, String raids) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int i = -1;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("update usertable set raids=? where uname=?");
            pstm.setString(1,raids);
            pstm.setString(2,uname);
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
    public User checkUname(String uname) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet res=null;
        User user=null;
        try {
            conn = JDBCUtils.getConnection();
            pstm = conn.prepareStatement("SELECT * from usertable where ifdelete=0 and uname=?");
            pstm.setString(1,uname);
            res= pstm.executeQuery();
            while (res.next()){
                user=new User(res.getInt("uid"),res.getString("uname"),
                        res.getString("upwd"),res.getString("usex"),
                        res.getDate("ubirthday"),res.getString("receiver"),
                        res.getString("raddress"), res.getString("rtelephone"),
                        res.getInt("rlevel"), res.getString("raids"),
                        res.getInt("ifdelete"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(res,pstm, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
