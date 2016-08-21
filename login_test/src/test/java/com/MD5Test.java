package com;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wangnianbao on 2016/8/21.
 */
public class MD5Test {
    public static void main(String[] args) {
        try {
            String string= "12345";
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.digest(string.getBytes());
            System.out.println("md:"+md5.getAlgorithm());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
