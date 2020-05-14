package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/2/17 9:22
 * @apiNote 斐波那契数列
 * 题目描述:
 * 1.大家都知道斐波那契数列，1，1，2，3，5，8，13
 * 2.这个规律很简单，其实就是F(n)=F(n-1)+F(n-2),第n个数等于第n个数的前面两个数之和
 * 3.现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）
 * 4.n<=39
 */
public class Fibonacci {


    /**
     * 1.递归解法
     *
     * @apiNote 思路：
     * 1.递归解决。
     * 2.使用递归，当递归的深度很大的时候，容易出现栈溢出的问题。
     * 3.使用递归会有重复计算问题，当递归的次数一多，重复的数会很多。
     * 4.时间复杂度：O(1)
     * 5.空间复杂度：O(n)
     */
    public static int fibonacci1(int n) {
        //鲁棒
        if (n <= 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }


    /**
     * 2.迭代解法
     *
     * @apiNote 思路：
     * 1.非递归解决，迭代
     * 2.通过记录一个元素的前两个元素，然后不断的相加，得到结果
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int fibonacci2(int n) {
        //鲁棒
        if (n <= 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        //第n个数的前一个数,初始值为1，因为数列的正数第二个数就是1
        int preN = 1;
        //第n个数的前一个数的前一个数，初始值为0，因为数列的第一个数就是从0开始的
        int prePreN = 0;
        //最终结果
        int result = 0;
        for (int i = 2; i <= n; i++) {
            //每次将第i个数的前面两个数相加得到第i个数的值
            result = preN + prePreN;
            //开始改变preN和prePreN的值，为下一次循环做准备
            //下一次的prePreN的值就是上次的preN值
            prePreN = preN;
            //下一次的preN值就是i的值
            preN = result;
        }
        //循环结束将结果输出
        return result;
    }


    /**
     * 3.动态规划解法
     *
     * @apiNote 思路：
     * 1.为了解决递归造成的重复计算问题，这里使用dp的思想，将之前算过的结果，记录下来
     * 2.dp[n]表示第n个斐波那契数列的值
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int fibonacci3(int n) {
        //鲁棒
        if (n <= 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        //dp数组，用来记录历史数据
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        for (int n = -1; n <= 8; n++) {
            System.out.println("1.使用递归方法:::::::" + "第" + n + "个斐波那契数列的值是：" + fibonacci1(n));
            System.out.println("2.使用尾递归方法:::::" + "第" + n + "个斐波那契数列的值是：" + fibonacci2(n));
            System.out.println("3.使用动态规划方法:::" + "第" + n + "个斐波那契数列的值是：" + fibonacci3(n));
            System.out.println("********************************************************");
        }
    }
}
