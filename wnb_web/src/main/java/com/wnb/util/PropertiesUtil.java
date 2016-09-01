package com.wnb.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wangnianbao on 2016/8/31.
 */
public class PropertiesUtil {
    private static Properties properties=new Properties();

    static {
        try {
            properties.load(PropertiesUtil.class.getResourceAsStream("/userinfo.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println(properties.getProperty("username"));
    }
    public static String  getProperty(String key){

        return properties.getProperty(key);
    }
}
