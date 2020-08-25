package com.bins.bishi.autumn2020.wanmeishijie;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/25 17:43
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 张三每天都去小王家偷桃子
     * 但是张三是一个有原则的小偷，他每次只偷一半加一个（例如为4，则偷2 + 1 一共三个）
     * 假设小王第N天发现自己只剩下一颗桃子，那么小王原本有几颗桃子
     * <p>
     * 输入描述
     * 天数
     * <p>
     * 输出描述
     * 原本桃子数量
     * <p>
     * <p>
     * 样例输入
     * 2
     * 样例输出
     * 10
     *
     * @apiNote 思路：
     * 1.其实是一道很简单的递归求解的问题
     * 2.类似于斐波那契数列的求解，我们只需要根据测试用例找规律求出每一组数据之间的关系
     * 3.比如说这里假设 N=1，那么就一定是4个
     * 4.N=2，那么就是10个
     * 5.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        if (day <= 0) {
            System.out.println(0);
        } else {
            long result = dfs(day, 1);
            long result1 = code(day);
            System.out.println(result);
            System.out.println(result1);
        }
    }

    /**
     * 递归法
     */
    public static int dfs(int day, int number) {
        //递归结束条件
        if (day <= 0) {
            return number;
        }
        return dfs(day - 1, 2 * number + 2);
    }

    /**
     * 解法二，迭代法
     *
     * @apiNote 思路：
     * 1.既然递归能够解决的，那么我们使用迭代也是可以解出来的
     * 2.递推公式就是：2*last+2
     */
    public static int code(int day) {
        int last = 1;
        for (int i = day; i > 0; i--) {
            last = 2 * last + 2;
        }
        return last;
    }
}
