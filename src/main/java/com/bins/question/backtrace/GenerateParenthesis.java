package com.bins.question.backtrace;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/4/22 14:48
 * @apiNote 括号生成
 */
public class GenerateParenthesis {


    private static HashSet<String> set = new HashSet<>();


    /**
     * 题目描述：
     * 1.数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合
     * <p>
     * 示例：
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     *
     * @apiNote 思路：
     * 1.解法一，回溯+暴力
     * 2.我们可以先根据所提供的括号对数生成所有括号序列
     * 3.然后检查每一个组合是否合法即可
     * 4.md超时了。。。
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        //生成括号组合
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("()");
        }
        LinkedList<Character> track = new LinkedList<>();
        boolean[] flag = new boolean[n * 2];
        generateHelper(builder.toString().toCharArray(), track, flag);
        for (String str : set) {
            str = str.replaceAll(",", "")
                    .replaceAll(" ", "")
                    .replaceAll("\\[", "")
                    .replaceAll("]", "");
            if (isValid(str)) {
                list.add(str);
            }
        }
        return list;
    }


    /**
     * 通过回溯生成括号序列
     */
    public static void generateHelper(char[] strs, LinkedList<Character> track, boolean[] flag) {
        //递归结束条件
        if (track.size() == strs.length) {
            LinkedList<Character> tmp = new LinkedList<>(track);
            set.add(tmp.toString());
        }
        //回溯
        for (int i = 0; i < strs.length; i++) {
            //已经使用过的元素不能重复使用
            if (!flag[i]) {
                flag[i] = true;
                track.add(strs[i]);
                generateHelper(strs, track, flag);
                track.removeLast();
                flag[i] = false;
            }
        }
    }


    /**
     * 校验组合是否是有效的括号序列
     *
     * @apiNote 思路：
     * 1.这里使用一种类似于抵消的思想来校验合法性
     * 2.因为所要校验的字符串只有两个内容，一个是“(”,一个是“)”
     * 3.合法的关键就是左括号出现的次数一定要等于右括号出现的次数
     * 4.所以我们设置一个count用来统计左右括号抵消的次数
     */
    public static boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            //如果count小于零，说明目前已经不可能匹配了
            if (count < 0) {
                return false;
            }
        }
        //count=0，匹配成功
        return count == 0;
    }


    /**
     * 解法二，bfs
     */
    public static List<String> generateParenthesisV2(int x) {
        List<String> list = new ArrayList<>();
        backTrace(list, new StringBuilder(), 0, 0, x);
        return list;
    }


    /**
     * 回溯
     */
    public static void backTrace(List<String> list, StringBuilder current, int left, int right, int max) {
        //递归结束条件
        if (current.length() == max * 2) {
            list.add(current.toString());
            return;
        }
        //左括号回溯,当左括号数量小于规定的左括号数时
        if (left < max) {
            current.append("(");
            backTrace(list, current, left + 1, right, max);
            current.deleteCharAt(current.length() - 1);
        }
        //右括号回溯，当此时的右括号数比左括号数要小的时候
        if (right < left) {
            current.append(")");
            backTrace(list, current, left, right + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        if (list != null && list.size() > 0) {
            System.out.println(list.toString());
        }
    }
}
