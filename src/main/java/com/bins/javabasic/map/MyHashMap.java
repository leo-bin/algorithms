package com.bins.javabasic.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author leo-bin
 * @date 2020/2/14 18:06
 * @apiNote HashMap学习
 */
public class MyHashMap {


    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        HashMap<String, Integer> map = new HashMap<>(16);
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>(16);

        map.put("语文", 90);
        map.put("数学", 96);
        map.put("英语", 99);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
