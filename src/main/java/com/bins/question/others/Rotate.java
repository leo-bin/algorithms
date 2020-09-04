package com.bins.question.others;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/9/4 16:45
 * @apiNote 旋转图像
 * 来源：leetcode-48
 * 链接：https://leetcode-cn.com/problems/rotate-image/
 */
public class Rotate {

    /**
     * 题目描述：
     * 1.给定一个 n × n 的二维矩阵表示一个图像
     * 2.将图像顺时针旋转 90 度
     * 3.说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵
     * 4.请不要使用另一个矩阵来旋转图像
     * <p>
     * 示例 1:
     * 给定 matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * <p>
     * 示例 2:
     * 给定 matrix =
     * [
     * [ 5, 1, 9,11],
     * [ 2, 4, 8,10],
     * [13, 3, 6, 7],
     * [15,14,12,16]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [15,13, 2, 5],
     * [14, 3, 4, 1],
     * [12, 6, 8, 9],
     * [16, 7,10,11]
     * ]
     *
     * @apiNote 思路：
     * 1.一开始没想到，通过观察规律可以发现我们只需要经过两次旋转即可实现翻转
     * 2.首先是将矩阵分成上下两层，分别进行倒置
     * 3.然后接下来沿着矩阵的对角线再次进行反转即可得到旋转后的图像
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(1)
     */
    public static void rotate(int[][] matrix) {
        //上下翻转
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            int[] t = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = t;
        }
        //对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
