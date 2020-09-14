package com.bins.question.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leo-bin
 * @date 2020/9/14 11:18
 * @apiNote 矩阵置零
 * 来源：leetcode-73
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class SetZeroes {

    /**
     * 题目描述：
     * 1.给定一个 m x n 的矩阵
     * 2.如果一个元素为 0，则将其所在行和列的所有元素都设为 0
     * 3.请使用原地算法
     * <p>
     * 示例 1:
     * 输入:
     * [
     * [1,1,1],
     * [1,0,1],
     * [1,1,1]
     * ]
     * 输出:
     * [
     * [1,0,1],
     * [0,0,0],
     * [1,0,1]
     * ]
     * <p>
     * 示例 2:
     * 输入:
     * [
     * [0,1,2,0],
     * [3,4,5,2],
     * [1,3,1,5]
     * ]
     * 输出:
     * [
     * [0,0,0,0],
     * [0,4,5,0],
     * [0,3,1,0]
     * ]
     * <p>
     * 进阶:
     * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案
     * 你能想出一个常数空间的解决方案吗？
     *
     * @apiNote 思路：
     * 1.这题没啥特别的，无非就是找到一种省空间的方法
     * 2.我们首先能够想到的就是一次遍历所有元素然后记录0的坐标，分别用两个set存行和列
     * 3.之后根据行和列去置0就行
     * 4.时间复杂度：O(m*n)
     * 5.空间复杂度：O(m+n)
     */
    public static void setZeroes(int[][] matrix) {
        //特判
        if (matrix.length <= 0) {
            return;
        }
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        //1.记录row和col
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        //2.row和col置0
        for (int row : rowSet) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for (int col : colSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.我们其实还可以接着优化空间
     * 2.优化空间其实就是找到一个地方来存那些需要置0的行和列
     * 3.要想实现O(1)的时间要么就是找到一个变量存所有的记录，但是很显然，这里需要记录的位置有很多
     * 4.那没办法，那就只能鸠占鹊巢了，我们想办法使用原始数组进行原地修改
     * 5.这里可以先遍历数组的首行和首列，使用两个变量记录首行和首列是否需要置0
     * 6.接下来我们只需要将剩下需要置0的行和列记录在首行和首列中就心
     * 7.时间复杂度：O(m*n)
     * 8.空间复杂度：O(2)
     */
    public static void setZeroesV2(int[][] matrix) {
        //1.记录首行和首列是否需要置0
        boolean rowFlag = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
                break;
            }
        }
        boolean colFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        //2.使用首行和首列记录所有需要置0的地方
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //3.分别遍历首行和首列判断当前行置零
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        //4.根据之前记录的标记位给首行和首列置0
        if (rowFlag) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroesV2(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
