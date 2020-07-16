package com.bins.algorithm.sort;

/**
 * @author leo-bin
 * @date 2020/4/26 17:19
 * @apiNote 插入排序
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @apiNote 思路：
     * 1.假设第一个数单独为一个数组，那么这么数组肯定是有序
     * 2.接下来只要数组中的每一个数和这个数组进行比较，找到自己的位置，然后插入这个数组就行（交换位置）
     * 3.比如说，target={3,2,4,5,1}
     * 第一次插入：{3}和2进行比较，满足条件插入相应的位置即可，变成了{2，3}
     * 第二次插入：{2，3}和4进行比较，变成{2，3，4}
     * 第三次插入：{2，3，4}和5比较。。。
     * 4.时间复杂度：O(n*n)
     * 5.稳定排序
     */
    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                }
            }
        }
        return nums;
    }


    public static void main(String[] args) {

    }
}
