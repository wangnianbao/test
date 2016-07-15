package com.wnb;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangnianbao on 2016/7/15.
 */
public class TestList {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0;i<10;i++){
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 6;i<15;i++){
            list2.add(i);
        }
        List<Integer> result = merge(list,list2);
        System.out.println("打印数组：");
        for (int i :result){
            System.out.println(i);
        }
    }

    public static List<Integer> merge(List<Integer> list,List<Integer> list2){
        List<Integer> result = new ArrayList<Integer>();
        if (list != null && list.size() >0){
            result.addAll(list);
        }

        for (int i:list2){
            boolean flag = false;
            for (int j : list){
                if (i == j){
                    flag = true;
                }
            }
            if (!flag){
                result.add(i);
            }
        }
        return result;
    }

}
