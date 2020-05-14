package com.bins.javabasic.map;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leo-bin
 * @date 2020/2/14 18:06
 * @apiNote ConcurrentHashMap学习
 */
public class MyConcurrentHashMap {


    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>(16);
        Vector<String> vector = new Vector<>(16);
    }
}
