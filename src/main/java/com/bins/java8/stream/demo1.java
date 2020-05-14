package com.bins.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leo-bin
 * @date 2020/1/9 10:38
 * @apiNote Stream测试样例1
 * 需求：
 * 给定一个list集合
 * 1.找出所有 长度>=5的字符串
 * 2.忽略大小写、去除重复字符串
 * 3.按字母排序
 * 4.最后用“❤”连接成一个字符串输出
 */
public class demo1 {

    /**
     * 判断字符串是否包含数字,一旦有一个数字数字返回true，否则false
     *
     * @param str
     * @return
     */
    public static Boolean isContainNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Stream一套带走
     */
    public static void streamTest(List<String> list) {
        //首先将列表转化为Stream流
        String result = list.stream()
                //筛选出字母型字符串
                .filter(i -> !isContainNum(i))
                //筛选出长度>=5的字符串
                .filter(i -> i.length() >= 5)
                // 字符串统一转小写
                .map(i -> i.toLowerCase())
                // 去重
                .distinct()
                // 字符串排序
                .sorted(Comparator.naturalOrder())
                // 字符串的拼接
                .collect(Collectors.joining("❤"));
        System.out.println(result);
    }


    public static void main(String[] args) {
        //初始化字符串
        String str = "1,2,bilibili,of,coder,5,at,BILIBILI,coder,23,CHEERS,6";
        //数组转list
        List<String> list = Arrays.asList(str.split(","));
        streamTest(list);
    }
}
