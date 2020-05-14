package com.bins.bishi.alibaba;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/3/30 16:11
 * @apiNote 2020-03-27 阿里笔试第一题
 */
public class StringTransfer {


    /**
     * 题目描述:
     * 1.给你两个字符串，要求你将字符串s1转换为s2
     * 2.每次可以将s1中的任意一个字符移动到s1的末尾
     * 3.当s1转换为s2时的最少转换次数
     * <p>
     * 输入：
     * acdk
     * <p>
     * ckad
     * 输出：
     * 2
     *
     * @apiNote 思路：
     * 1.贪心思路
     * 2.
     */
    public static int minTransfer(String str1, String str2) {
        int count = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        //鲁棒
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        List<String> list1 = Arrays.asList(str1.split(""));
        List<String> list2 = Arrays.asList(str2.split(""));
        //检查str1中的字符是否存在于str2中
        for (int i = 0; i < len1; i++) {
            if (!list2.contains(list1.get(i))) {
                return 0;
            }
        }
        for (int i = 0; i < len1; i++) {
            if (list1.get(i).equals(list2.get(count))) {
                count++;
            }
        }
        return len1 - count;
    }


    /**
     * 输入输出：
     * Scanner scanner = new Scanner(System.in);
     * String str1 = scanner.nextLine();
     * String str2 = scanner.nextLine();
     * System.out.println(minTransfer(str1, str2));
     */
    public static void main(String[] args) {
        String str1 = "acdk";
        String str2 = "ckad";
        System.out.println(minTransfer(str1, str2));
    }
}
