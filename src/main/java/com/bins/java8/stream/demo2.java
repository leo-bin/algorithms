package com.bins.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author leo-bin
 * @date 2020/1/9 10:59
 * @apiNote 如何优雅的打印数组
 */
public class demo2 {


    /**
     * 传统的迭代大法
     *
     * @param strs
     */
    public static void printArrays1(String[] strs) {
        System.out.println("使用传统的迭代方法测试结果：");
        for (String s : strs) {
            System.out.println(s);
        }
    }

    /**
     * 使用Stream
     *
     * @param strs
     */
    public static void printArrays2(String[] strs) {
        System.out.println("使用Java8新特性Stream方法测试结果：");
        //第一种
        System.out.println("第一种");
        Arrays.asList(strs).stream().forEach(s -> System.out.println(s));
        //第二种
        System.out.println("第二种");
        Stream.of(strs).forEach(System.out::println);
        //第三种
        System.out.println("第三种");
        Arrays.stream(strs).forEach(System.out::println);
    }

    /**
     * 使用Arrays的toString方法
     *
     * @param strs
     */
    public static void printArrays3(String[] strs) {
        System.out.println("使用Arrays的toString方法测试结果：");
        System.out.println(Arrays.toString(strs));
    }

    public static void main(String[] args) {
        //初始化字符串
        String str = "1,2,bilibili,of,coder,5,at,BILIBILI,coder,23,CHEERS,6";
        //字符串转字符数组
        String[] strs = str.split(",");
        printArrays1(strs);
        printArrays2(strs);
        printArrays3(strs);
    }
}
