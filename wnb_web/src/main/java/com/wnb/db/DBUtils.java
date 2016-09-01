package com.wnb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by wangnianbao on 2016/8/31.
 */
public class DBUtils {
    private static String username;
    private static String password;
    private static String ip;
    private static String dataBase;
    private static String port;
    private static Properties properties=new Properties();
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(getConnUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    //获取链接地址 函数 getConnUrl()
    private static String getConnUrl(){
//"jdbc:mysql://localhost:3307/test?user=root&password=&useUnicode=true&characterEncoding=UTF8";
        StringBuffer sb = new StringBuffer();
        sb.append("jdbc:mysql://").append(ip).append(":").append(port)
                .append("/").append(dataBase).append("?").append("user=").append(username).append("&password=")
                .append("&useUnicode=true&characterEncoding=UTF8");
        return sb.toString();
    }
    public static void close(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
