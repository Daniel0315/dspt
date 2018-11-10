package com.neuedu.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

public class JDBCUtils {
    /**
     * 加载驱动
     */
    static {
        try {
            Class.forName(PropertiesUtils.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接连接池
     */
    private static DruidDataSource dataSource=null;
    static {
        dataSource=new DruidDataSource();
        dataSource.setUrl(PropertiesUtils.URL);
        dataSource.setUsername(PropertiesUtils.USERNAME);
        dataSource.setPassword(PropertiesUtils.PASSWORD);
    }

    /**
     * Connection 对象的工具方法
     */
    public static Connection getConnection() throws SQLException {
        Connection conn=null;
        conn=dataSource.getConnection();
        return conn;
    }

    public static void insertData(PreparedStatement preparedStatement,Object ...objs) throws SQLException {
        if (objs!=null&&objs.length>0){
            for (int i = 0; i < objs.length; i++) {
                preparedStatement.setObject(i+1,objs[i]);
            }
        }
    }
    /**
     * 关闭的工具方法
     */
    public static void close(Object ...objs) throws SQLException {
        if (objs!=null&&objs.length>0){
            for (Object o : objs) {
                if (o!=null){
                    if (o instanceof Connection){
                        ((Connection) o).close();
                    }
                    if (o instanceof Statement){
                        ((Statement) o).close();
                    }
                    if (o instanceof ResultSet){
                        ((ResultSet) o).close();
                    }
                }
            }
        }
    }


}
