package com.bins.question.binary;

/**
 * @author leo-bin
 * @date 2020/3/24 14:48
 * @apiNote 二维数组的查找
 */
public class ArrayFind2D {


    /**
     * 题目描述：
     * 1.在一个二维数组中（每个一维数组的长度相同）
     * 2.每一行都按照从左到右递增的顺序排序
     * 3.每一列都按照从上到下递增的顺序排序。请完成一个函数
     * 4.输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
     * <p>
     * 例如：
     * array =
     * {
     * {1, 2, 3},
     * {2, 3, 4},
     * {3, 4, 5}
     * };
     *
     * @apiNote 思路：
     * 1.把二维数组看成多个一维数组
     * 2.分别对一维数组使用二分查找
     * 3.时间复杂度：O(n*(log(n))
     * 4.空间复杂度：O(1)
     */
    public static boolean arrayFind(int[][] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int low = 0;
            int high = nums.length - 1;
            int mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (target == nums[i][mid]) {
                    return true;
                } else if (target > nums[i][mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int target = 6;
        if (arrayFind(array, target)) {
            System.out.println("找到了:" + target);
        } else {
            System.out.println("没有找到:" + target);
        }
    }
}
