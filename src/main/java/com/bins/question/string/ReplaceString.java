package com.bins.question.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/13 16:35
 * @apiNote 字符串替换
 */
public class ReplaceString {


    /**
     * 题目描述：
     * 1.给定一个仅由小写字母x和y组成且长度不超过10^5的字符串
     * 2.每次可以将字符串中的一个子串xy替换成字符串yyx
     * 3.那么至少要替换多少次才能让字符串中不存在子串xy？
     * <p>
     * 输入描述:
     * 输入给定的字符串
     * <p>
     * 输出描述:
     * 输出最少替换次数对10^9+7取模后的结果
     * <p>
     * 输入例子1:
     * xxy
     * <p>
     * 输出例子1:
     * 3
     *
     * @apiNote 思路：
     * 1.
     */
    public static int replaceString(String str) {
        //鲁棒
        if (!isContains(str)) {
            return 0;
        }
        int count = 0;
        StringBuilder tmp = new StringBuilder();
        String newStr = str;
        while (true) {
            for (int i = 0; i < newStr.length() - 1; i++) {
                if (("" + newStr.charAt(i) + newStr.charAt(i + 1)).equals("xy")) {
                    tmp.append("yyx");
                    count++;
                    i++;
                } else {
                    tmp.append(newStr.charAt(i));
                }
            }
            if (!isContains(tmp.toString())) {
                break;
            }
            newStr = tmp.toString();
            //清空StringBuilder
            tmp.delete(0, tmp.length());
        }
        return (count % (int) (Math.pow(10, 9) + 7));
    }


    /**
     * 是否包含“xy”
     */
    public static boolean isContains(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            list.add("" + str.charAt(i) + str.charAt(i + 1));
            if (list.contains("xy")) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        /*String str="xxy";
        String str1="yyx";
        System.out.println(replaceString(str));
        System.out.println(replaceString(str1));*/

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(replaceString(str));
    }
}
