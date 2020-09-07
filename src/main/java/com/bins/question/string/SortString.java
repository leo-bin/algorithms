package com.bins.question.string;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/9/7 19:21
 * @apiNote 字符串的排序
 */
public class SortString {

    /**
     * 题目描述：
     * 1.给你一个字符串数组
     * 2.要求你按照字典序将每一个字符串进行重新排序之后输出
     *
     * @apiNote 思路：
     * 1.使用快排的思想并利用compareTo方法
     * 2.时间复杂度：O(n*n*log(n))
     * 3.空间复杂度：O(n)
     */
    public static void sortString(String[] strings) {
        quickSort(strings, 0, strings.length - 1);
    }

    /**
     * 快排
     */
    public static void quickSort(String[] strings, int left, int right) {
        //递归结束条件
        if (left > right) {
            return;
        }
        int midIndex = partition(strings, left, right);
        quickSort(strings, left, midIndex - 1);
        quickSort(strings, midIndex + 1, right);
    }

    /**
     * 分治
     */
    public static int partition(String[] strings, int left, int right) {
        int midIndex = left;
        String midValue = strings[midIndex];
        while (left != right) {
            //使用原生的String.comparedTo方法
           /* while (left < right && strings[right].compareTo(midValue) > 0) {
                right--;
            }
            while (left < right && strings[left].compareTo(midValue) <= 0) {
                left++;
            }*/
            //自己重写comparedTo方法
            while (left < right && comparedTo(strings[right], midValue) > 0) {
                right--;
            }
            while (left < right && comparedTo(strings[left], midValue) <= 0) {
                left++;
            }
            if (left < right) {
                String s = strings[right];
                strings[right] = strings[left];
                strings[left] = s;
            }
        }
        strings[midIndex] = strings[left];
        strings[left] = midValue;
        return left;
    }

    /**
     * 自己重写compared方法
     */
    public static int comparedTo(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < len) {
            if (chs1[index] != chs2[index]) {
                return chs1[index] - chs2[index];
            }
            index++;
        }
        return s1.length() - s2.length();
    }


    public static void main(String[] args) {
        String[] strings = {"aab", "aac", "aaa", "aad"};
        sortString(strings);
        System.out.println(Arrays.toString(strings));
    }
}
