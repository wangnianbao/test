package com.wnb.db;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.wnb.model.UserInfo1;
import com.wnb.util.MD5Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by wangnianbao on 2016/8/31.
 */
public class DataBaseDao {
    public static boolean insert(String username ,String password, String xueli,String sex) {
        Connection connection = DBUtils.getConnection();
        if (connection == null) {
            System.out.println("connection 为空!");
            return false;
        }
        try {
            String passwordMd5 = MD5Utils.getHash(password, MD5Utils.MD5);
            Statement stmt = connection.createStatement();
            String sql = "insert into usermessage(username,password,xueli,sex)" +
                    " values('" + username + "','" + passwordMd5 + "','" + xueli + "','" + sex + "')";
            int result = stmt.executeUpdate(sql);
            System.out.println("操作数据库结果为空！"+ result);
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection);
        }
        return false;
    }
   public static List<UserInfo1>query(String username) {
      Connection connection=DBUtils.getConnection();
       List<UserInfo1> result= Lists.newArrayList();
       if(connection==null){
           System.out.println("connection 为空");
           return  result;
       }try{
           Statement stmt = connection.createStatement();
           String sql;
           if(Strings.isNullOrEmpty(username)){
               sql="select username,xueli,sex from usermessage ";
           }else {
           sql = "select username,xueli,sex from usermessage where username='"+username+"'";
       }
           ResultSet rs=stmt.executeQuery(sql);
           System.out.println("操作数据库结果为：");
           while(rs.next()) {
               UserInfo1 userInfo1 = new UserInfo1();
               for (int i = 1; i <= 3; i++) {
                   if (i == 1) {
                       userInfo1.setName(String.valueOf(rs.getObject(i)));
                   }
                   if (i == 2) {
                       userInfo1.setName(String.valueOf(rs.getObject(i)));
                   }
                   if (i == 3) {
                       userInfo1.setName(String.valueOf(rs.getObject(i)));
                   }
               }
               result.add(userInfo1);
           }
       }catch (SQLException e) {
          e.printStackTrace();
       }finally {
           DBUtils.close(connection);
       }
       return  result;
   }
}
