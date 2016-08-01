package com.wnb.web.db;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by wangnianbao on 2016/7/27.
 */
public class DBUtils {
    private static String  username;
    private static String  password;
    private static String  dataBase;
    private static String  ip;
    private static String  port;
    private static Properties properties=new Properties();
    static {
        try {
            properties.load(DBUtils.class.getResourceAsStream("/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        dataBase = properties.getProperty("database");
        ip = properties.getProperty("ip");
        port = properties.getProperty("port");
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        // 避免中文乱码要指定useUnicode和characterEncoding
        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
        // 下面语句之前就要先创建javademo数据库
        String url = "jdbc:mysql://localhost:3307/test?"
                + "user=root&password=&useUnicode=true&characterEncoding=UTF8";

        try {
            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // or:
            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            // or：
            // new com.mysql.jdbc.Driver();

            System.out.println("成功加载MySQL驱动程序");
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection(url);
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
           // sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
            sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                System.out.println("创建数据表成功");
                sql = "insert into student(NO,name) values('2012001','陶伟基')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','周小俊')";
                result = stmt.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }

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
