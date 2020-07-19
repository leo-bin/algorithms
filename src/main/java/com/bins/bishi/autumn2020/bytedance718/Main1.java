package com.bins.bishi.autumn2020.bytedance718;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/18 21:09
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.对山脉数组进行排序
     * 2.然后去重之后输出
     * 3.要求时间：O(n),空间O(1)
     * <p>
     * 示例：
     * nums[1,2,2,5,10,9,8,2,1,1]
     * 输出：{1，2，5，8，9，10}
     *
     * @apiNote 思路：
     * 1.先使用二分找峰顶元素的下标peekIndex
     * 2.确定下标之后就可以将山脉数组看成两个数组
     * 3.我们定两个指针：i和j分别指向原数组的第一个和最后一个位置
     * 4.然后i往又走，一直到peekIndex，j则往左走，也是一直到peekIndex
     * 5.遍历的同时比较i和j指向元素的大小，选择小的存起来，最后就能得到一个有序的数组
     * 6.但是问题是如何去重，这里限制了空间，所以不能用哈希表
     * 7.但是因为此时的结果数组是有序的，所以我们一次遍历的同时判断是否重复，重复了就删掉，剩下的就是结果了
     */
    public static int[] code(int[] nums) {
        int peekIndex = findPeekIndex(nums);

        return nums;
    }


    /**
     * 找峰值坐标
     */
    public static int findPeekIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
