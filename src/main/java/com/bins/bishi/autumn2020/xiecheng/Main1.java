package com.bins.bishi.autumn2020.xiecheng;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/15 18:05
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 天会SOHO最近正在进行道路建设，现在有充足的长度为a和长度为b的两种规格的瓷砖
     * 现在从这些瓷砖中任取k块来铺路，请按递增的顺序输出所有可能的铺成道路的长度
     * <p>
     * 输入描述
     * 输入为3个数，每行1个数，第一个数表示a，第二个数表示b，第三个数表示k
     * a和b均为正整数，0 <= k <= 100000
     * <p>
     * 输出描述
     * 输出的结果为一个数组，数组中的值从小到大排列，如：[3,4,5,6]。如果数组为空则输出为[]，如果有相同的结果去除重复的。
     * <p>
     * 样例输入
     * 1
     * 2
     * 3
     * <p>
     * 样例输出
     * [3,4,5,6]
     * <p>
     * 提示
     * 可以使用 3 次 a，得到结果 3；
     * 使用 2 次 a 和 1 次 b，得到结果 4
     * 以此类推，得到最终结果
     *
     * @apiNote 思路：
     * 1.贪心
     * 2.没问题，a了
     */
    public static int[] divingBoard(int a, int b, int k) {
        //特判
        if (k == 0) {
            return new int[0];
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = k, j = 0; i >= 0 && j <= k; i--, j++) {
            int t = a * i + b * j;
            set.add(t);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int n : set) {
            result[index++] = n;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();
        int[] result = divingBoard(a, b, k);
        System.out.println(Arrays.toString(result));
    }
}
