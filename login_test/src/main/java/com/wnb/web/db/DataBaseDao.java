package com.wnb.web.db;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.wnb.web.model.UserInfo;
import com.wnb.web.util.MD5Utils;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by wangnianbao on 2016/7/30.
 */
public class DataBaseDao {
    public static boolean insert(String username,String password,String xueli,String sex){
        Connection connection = DBUtils.getConnection();
        if (connection == null){
            System.out.println("connection 为空！");
            return false;
        }
        try {
            String passwordMd5 = MD5Utils.getHash(password,MD5Utils.MD5);
            Statement stmt = connection.createStatement();
            String sql = "insert into usermessage(username,password,xueli,sex) values('"+username+"','"+passwordMd5+"','"+xueli+"','"+sex+"')";
            int result = stmt.executeUpdate(sql);
            System.out.println("操作数据库结果为空：" + result);
            if (result > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);
        }
        return false;
    }

    public static boolean isLogin(String username,String password){
        Connection connection = DBUtils.getConnection();
        if (connection == null){
            System.out.println("connection 为空！");
            return false;
        }
        try {
            Statement stmt = connection.createStatement();
            String passwordMd5 = MD5Utils.getHash(password,MD5Utils.MD5);
           // String sql = "insert into usermessage(username,password,xueli,sex) values('"+username+"','"+password+"','"+xueli+"','"+sex+"')";
           String  sql = "select * from usermessage where username='"+username+"' and password='"+passwordMd5+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("操作数据库结果为" );
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);
        }
        return false;
    }

    public static List<UserInfo> query(String username){
        Connection connection = DBUtils.getConnection();
        List<UserInfo> result = Lists.newArrayList();
        if (connection == null){
            System.out.println("connection 为空！");
            return result;
        }
        try {
            Statement stmt = connection.createStatement();
            // String sql = "insert into usermessage(username,password,xueli,sex) values('"+username+"','"+password+"','"+xueli+"','"+sex+"')";
            String  sql;
            if (Strings.isNullOrEmpty(username)){
                sql = "select username,xueli,sex from usermessage ";
            }else {
                sql = "select username,xueli,sex from usermessage where username='"+username+"'";
            }

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("操作数据库结果为" );
            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                for (int i = 1;i<=3 ;i++){
                    if (i ==1){
                        userInfo.setName(String.valueOf(rs.getObject(i)));
                    }
                    if (i ==2){
                        userInfo.setXueli(String.valueOf(rs.getObject(i)));
                    }
                    if (i ==3){
                        userInfo.setSex(String.valueOf(rs.getObject(i)));
                    }
                }
                result.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);
        }
        return result;
    }
}
