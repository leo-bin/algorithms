package com.bins.question.backtrace;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/24 15:37
 * @apiNote 字符串的排列
 */
public class PermuteString {

    /**
     * 使用TreeSet去重并按字典排序
     */
    private static TreeSet<String> set = new TreeSet<>();


    /**
     * 题目描述：
     * 1.输入一个字符串,按字典序打印出该字符串中字符的所有排列
     * 2.例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
     * <p>
     * 输入描述:
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
     *
     * @apiNote 思路：
     * 1.回溯
     */
    public static ArrayList<String> permuteString(String str) {
        //鲁棒
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        //存每一次新的排列结果
        StringBuilder track = new StringBuilder();
        //记录所有使用过的字母
        boolean[] flag = new boolean[str.length()];
        //开始回溯
        backtrace(track, str, flag);
        return new ArrayList<>(set);
    }


    /**
     * 回溯
     */
    public static void backtrace(StringBuilder track, String str, boolean[] flag) {
        //1.递归结束条件
        if (track.length() == str.length()) {
            set.add(track.toString());
            return;
        }
        //2.分别对所有字母进行回溯
        for (int i = 0; i < str.length(); i++) {
            //去掉已经记录过的字母
            if (!flag[i]) {
                //当前字母已经被使用过
                flag[i] = true;
                //记录当前字母
                track.append(str.charAt(i));
                backtrace(track, str, flag);
                //删除当前的字母的记录
                track.deleteCharAt(track.length() - 1);
                //恢复
                flag[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        String str = "aa";
        List<String> result = permuteString(str);
        if (result.size() >= 1) {
            System.out.println(result.toString());
        } else {
            System.out.println("字符串为空！");
        }
    }
}
