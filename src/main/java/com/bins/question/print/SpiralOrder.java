package com.bins.question.print;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/6/5 17:25
 * @apiNote 打印螺旋矩阵
 * 来源：leetcode-面试题29，主站54，剑指offer原题
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class SpiralOrder {


    /**
     * 题目描述：
     * 1.输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * <p>
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @apiNote 思路：
     * 1.一开始我是没有任何思路的
     * 2.发现这个题目的边界条件实在是太难受了
     * 3.这里参考了高赞解答的解法，采用从外面开始层层遍历的方式
     * 4.时间复杂度：O(m*n)
     * 5.空间复杂度：O(1)
     */
    public static int[] spiralOrder(int[][] matrix) {
        //特判
        if (matrix.length == 0) {
            return new int[0];
        }
        //上下左右的界限
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int x = 0;
        int[] result = new int[(right + 1) * (down + 1)];
        while (true) {
            //1.从左向右走
            for (int i = left; i <= right; i++) {
                result[x++] = matrix[up][i];
            }
            if (++up > down) {
                break;
            }
            //2.从上到下
            for (int i = up; i <= down; i++) {
                result[x++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            //3.从右往左
            for (int i = right; i >= left; i--) {
                result[x++] = matrix[down][i];
            }
            if (up > --down) {
                break;
            }
            //4.从下往上
            for (int i = down; i >= up; i--) {
                result[x++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result));
    }
}
