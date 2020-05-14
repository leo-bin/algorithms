package com.bins.question.array;

/**
 * @author leo-bin
 * @date 2020/3/24 14:48
 * @apiNote 一维数组的查找
 * 1.这里需要指明的是，我们的数组都是有序的
 * 2.因为数组无序，不管你使用什么方法来查找，性能都是一样的
 * 3.每一个元素出现的概率都是1/n
 */
public class ArrayFind1D {


    /**
     * 顺序查找
     *
     * @apiNote 思路：
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(1)
     */
    public static int find1(int[] nums, int target) {
        //鲁棒
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 二分查找
     *
     * @apiNote 思路：
     * 1.分别设置三个指针left，mid和right
     * 2.通过不断缩小比较的范围来查找元素
     * 3.时间复杂度：O(logn)
     * 4.空间复杂度：O(1)
     */
    public static int find2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int target = 5;
        System.out.println("解法一：顺序查找：：元素：" + target + "在数组中的位置是：" + find1(nums, target));
        System.out.println("解法二：二分查找：：元素：" + target + "在数组中的位置是：" + find2(nums, target));
    }
}
