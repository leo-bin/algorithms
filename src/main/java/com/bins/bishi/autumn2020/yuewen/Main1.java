package com.bins.bishi.autumn2020.yuewen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/10/21 18:07
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.给定一个整型正方形矩阵 Matrix
     * 2.请把该矩阵调整成顺时针旋转90度的样子
     * <p>
     * 输入描述:
     * 输入1+N行，第一行为矩阵行的个数N
     * 第2行到N+1数组中每行的数据，数字之间用英文逗号分隔
     * <p>
     * 输出描述:
     * 请遍历输出矩阵到一行
     * <p>
     * 示例1
     * 输入
     * 4
     * 1,2,3,4
     * 5,6,7,8
     * 9,10,11,12
     * 13,14,15,16
     * <p>
     * 输出
     * 13,9,5,1,14,10,6,2,15,11,7,3,16,12,8,4
     * <p>
     * 备注:
     * 额外空间复杂度为O(1)
     *
     * @apiNote 思路：
     * 1.上下反转+对角线反转
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(",");
            for (int j = 0; j < s.length; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
        //上下反转
        for (int i = 0, j = matrix[0].length - 1; i < j; i++, j--) {
            int[] m = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = m;
        }

        //对角线反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        //打印结果
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //不打印最后一个逗号
                if (i == (matrix.length - 1) && j == (matrix[0].length - 1)) {
                    System.out.println(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + ",");
                }
            }
        }
    }
}
