package com.bins.bishi.autumn2020.yongyou;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/18 15:35
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述
     * 1.将矩阵二维数组上下翻转
     * <p>
     * 示例1
     * 输入
     * [[1,2,3],[4,5,6],[7,8,9]]
     * <p>
     * 输出
     * [[7,8,9],[4,5,6],[1,2,3]]
     *
     * @apiNote 思路：
     * 1.
     */
    public static int[][] convert(int[][] matrix) {
        //特判
        if (matrix.length <= 0) {
            return matrix;
        }
        for (int i = 0, j = matrix.length - 1; i < matrix.length / 2 && j >= matrix.length / 2; i++, j--) {
            //交换
            int[] t = matrix[j];
            matrix[j] = matrix[i];
            matrix[i] = t;
        }
        return matrix;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = convert(matrix);
        for (int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}
