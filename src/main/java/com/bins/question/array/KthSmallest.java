package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/7/13 11:09
 * @apiNote 有序矩阵中第K小的元素
 * 来源：leetcode-378
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallest {

    /**
     * 题目描述：
     * 1.给定一个n x n矩阵
     * 2.其中每行和每列元素均按升序排序，找到矩阵中第k小的元素
     * 3.请注意，它是排序后的第k小元素，而不是第k个不同的元素
     * <p>
     * 示例：
     * matrix = [
     * [ 1,  5,  9],
     * [10, 11, 13],
     * [12, 13, 15]
     * ],
     * k = 8,
     * 返回 13
     * <p>
     * 提示：你可以假设k的值永远是有效的:1 ≤ k ≤ n^2
     *
     * @apiNote 思路：
     * 1.二分思想
     * 2.我的天，这种解法怎么可能在笔试中写出来？简直就是变态！只能理解记下来了。。。
     * 3.总体的思想就是通过二分不断的找一个mid值
     * 4.这个mid要满足所有在它上半部分的元素都要小于等于它
     * 5.如果满足了这个条件，在不断的进行二分，知道left=right
     * 6.此时的mid值就一定是我们要找的第k小的元素
     * 7.这个题的思想其实很容易理解，只要更着测试用例走一遍就行
     * 8.时间复杂度：O(n*log(n))
     * 9.空间复杂度：O(1)
     */
    public static int kthSmallest(int[][] matrix, int k) {
        //找矩阵中最小和最大的数作为下限和上限
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            //虽满足条件但不一定是目标值，所以需减少上限继续二分
            if (check(matrix, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 检查当前找到的元素个数是否等于目标个数k
     */
    public static boolean check(int[][] matrix, int target, int k) {
        int i = matrix.length - 1, j = 0;
        int count = 0;
        while (i >= 0 && j < matrix.length) {
            //如果当前值小于等于目标值，统计个数并右移（注意这里是按列来计算）
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                //上移
                i--;
            }
        }
        return count >= k;
    }



    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
}
