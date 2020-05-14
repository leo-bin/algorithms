package com.bins.bishi.qiniuyun;


import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/4/29 17:09
 * @apiNote
 */
public class Main1 {


    /**
     * 题目描述：
     * 1.给定一个正整数序列，请尝试通过将它们重新排列，组合成一个最小的整数
     * 2.例如输入为数组 [3, 6, 9, 12]，返回值为12369
     * 3.由于有可能会超出整数最大范围，所以请返回字符串类型
     *
     * @apiNote 思路：
     * 1.api暴力解决
     * 2.时间复杂度：O(n*log(n))
     * 3.空间复杂度：O(n)
     */
    public static String reMergeArray(int[] array) {
        int len = array.length;
        //鲁棒
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return "" + array[0];
        }
        StringBuilder result = new StringBuilder();
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = array[i] + "";
        }
        Arrays.sort(strs);
        for (String string : strs) {
            result.append(string);
        }
        return result.toString();
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.
     */
    public static String reMergeArrayV2(int[] array) {


        return "";
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 9, 12};
        int[] array1 = {3, 14};
        System.out.println(reMergeArray(array));
        System.out.println(reMergeArray(array1));
    }
}
