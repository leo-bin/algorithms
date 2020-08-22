package com.bins.bishi.autumn2020.sanliuling360;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/22 17:38
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给定一个1到N的排列P1到PN（N为偶数）初始时Pi=i（1≤i≤N）
     * 2.现在要对排列进行M次操作，每次操作为以下两种中一种
     * ①将排列的第1个数移到末尾；
     * ②交换排列的第1个数与第2个数、第3个数与第4个数、...、第N-1个数与第N个数
     * 3.求经过这M次操作后得到的排列。
     * <p>
     * 输入描述
     * 第一行包含两个整数N和M，2≤N，M≤10^5
     * 第二行包含M个空格隔开的整数t1到tM，1≤ti≤2
     * 若ti=1，则表示第i次操作为操作①；
     * 若ti=2，则表示第i次操作为操作②
     * <p>
     * 输出描述
     * 输出N个空格隔开的整数，即经过M次操作后得到的排列。
     * <p>
     * 样例输入
     * 4 3
     * 1 2 1
     * <p>
     * 样例输出
     * 2 1 4 3
     * <p>
     * 提示:排列变化过程为：{1 2 3 4}->{2 3 4 1}->{3 2 1 4}->{2 1 4 3}。
     *
     * @apiNote 思路：
     * 1.暴力模拟
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] nums = new int[M];
        for (int i = 0; i < M; i++) {
            nums[i] = scanner.nextInt();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            builder.append(i);
        }

        //开始遍历操作数组
        for (int n : nums) {
            if (n == 1) {
                if (builder.length() >= 1) {
                    char head = builder.charAt(0);
                    builder.deleteCharAt(0);
                    builder.append(head);
                }
            } else {
                if (builder.length() >= 1) {
                    StringBuilder newBuilder = new StringBuilder();
                    for (int i = 0, j = 2; i < builder.length() - 1 && j < builder.length() - 1; i += 4, j += 6) {
                        newBuilder.append(builder.charAt(i + 1));
                        newBuilder.append(builder.charAt(i));
                        newBuilder.append(builder.charAt(j + 1));
                        newBuilder.append(builder.charAt(j));
                    }
                    builder = newBuilder;
                }
            }
        }

        //输出结果
        for (int i = 0; i < builder.length(); i++) {
            System.out.print(builder.charAt(i) + " ");
        }
    }
}
