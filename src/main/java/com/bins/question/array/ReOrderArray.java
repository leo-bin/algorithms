package com.bins.question.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/8 16:41
 * @apiNote 重排序数组使得所有偶数和奇数分开
 */
public class ReOrderArray {


    /**
     * 题目描述：
     * 1.输入一个整数数组
     * 2.实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
     * 3.并保证奇数和奇数，偶数和偶数之间的相对位置不变
     * <p>
     * 示例：
     * 输入：{1，2，3，4，5，6，7}
     * 输出：{1，3，5，7，2，4，6}
     *
     * @apiNote 思路：
     * 1.解法一，暴力
     * 2.开辟两个list，一个奇数list，一个偶数list
     * 3.一次遍历将数组中的奇数和偶数按顺序找出来存分别存list
     * 4.再开一个数组，长度和原数组一样，先后遍历奇数list和偶数list，将数据存数组
     * 5.时间复杂度：O(n)
     * 6.空间复杂复：O(n)
     */
    public static void reOrderArray(int[] nums) {
        int len = nums.length;
        if (len > 0) {
            List<Integer> listOdd = new ArrayList<>();
            List<Integer> listEven = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if ((nums[i] & 1) == 1) {
                    listOdd.add(nums[i]);
                } else {
                    listEven.add(nums[i]);
                }
            }
            int flag = 0;
            for (; flag < listOdd.size(); flag++) {
                nums[flag] = listOdd.get(flag);
            }
            for (int i = flag, j = 0; j < listEven.size() && i < len; i++, j++) {
                nums[i] = listEven.get(j);
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
