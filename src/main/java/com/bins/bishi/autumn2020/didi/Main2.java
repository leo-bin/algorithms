package com.bins.bishi.autumn2020.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/21 17:53
 * @apiNote
 */
public class Main2 {


    /**
     * 题目描述：
     * 小明昨晚做了一个梦。
     * 在梦里，很多很多斐波那契数连成了一条蛇。
     * 突然，最大的那个数变成了蛇头，把小明一口给吞到肚子里去了。
     * 小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇
     * 这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。
     * 第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
     * 小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
     * <p>
     * 输入描述
     * 单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
     * <p>
     * 输出描述
     * 输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
     * <p>
     * 样例输入
     * 3
     * <p>
     * 样例输出
     * 34 21 13
     * 1 1 8
     * 2 3 5
     *
     * @apiNote 思路：
     * 1.蛇形打印问题
     * 2.先构造一个n*n大小的斐波那契数组
     * 3.按照蛇形打印的方式开始遍历
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //特判
        if (n == 1) {
            System.out.println(n);
        } else {
            //构造数组
            int[] dp = new int[n * n];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n * n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            //开始蛇形打印
            int[][] matrix = new int[n][n];
            int left = 0, right = n - 1, up = 0, down = n - 1, index = n * n - 1;
            while (true) {
                //1.left to right
                for (int i = left; i <= right; i++) {
                    matrix[up][i] = dp[index--];
                }
                if (++up > down) {
                    break;
                }
                //2.up to down
                for (int i = up; i <= down; i++) {
                    matrix[i][right] = dp[index--];
                }
                if (right-- < left) {
                    break;
                }
                //3.right to left
                for (int i = right; i >= left; i--) {
                    matrix[down][i] = dp[index--];
                }
                if (down-- < up) {
                    break;
                }
                //4.down to up
                for (int i = down; i >= up; i--) {
                    matrix[i][left] = dp[index--];
                }
                if (++left > right) {
                    break;
                }
            }
            for (int[] m : matrix) {
                System.out.println(Arrays.toString(m));
            }
        }
    }
}
