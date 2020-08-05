package com.bins.bishi.autumn2020.jingdong.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/5 10:16
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.春天是鲜花的季节，水仙花就是其中最迷人的代表
     * 2.数学上有个水仙花数，他是这样定义的：
     * 3.“水仙花数”是指一个三位数，它的各位数字的立方和等于其本身
     * 4.比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
     * <p>
     * 输入描述
     * 输入数据有多组，每组占一行，包括两个整数m和n（100<=m<=n<=999）
     * <p>
     * 输出描述
     * 对于每个测试实例，要求输出所有在给定范围内的水仙花数
     * 就是说，输出的水仙花数必须大于等于m,并且小于等于n
     * 如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开
     * 如果给定的范围内不存在水仙花数，则输出no; 每个测试实例的输出占一行
     * <p>
     * 样例输入
     * 100 120
     * 300 380
     * <p>
     * 样例输出
     * no
     * 370 371
     *
     * @apiNote 思路：
     * 1.
     */
    public static List<Integer> code(int m, int n) {
        List<Integer> result = new ArrayList<>();
        if (m >= 100 && m <= n && n <= 999) {
            for (int i = m; i <= n; i++) {
                if (check(i)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    /**
     * 打印
     */
    public static void print(List<Integer> list) {
        for (int n : list) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    /**
     * 是否是水仙花数
     */
    public static boolean check(int n) {
        int gewei = n % 10;
        int shiwei = (n / 10) % 10;
        int baiwei = (n / 100) % 10;
        return (Math.pow(gewei, 3) + Math.pow(shiwei, 3) + Math.pow(baiwei, 3)) == n * 1.0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            List<Integer> result = code(m, n);
            if (result != null && result.size() > 0) {
                print(result);
            } else {
                System.out.println("no");
            }
        }
    }


}
