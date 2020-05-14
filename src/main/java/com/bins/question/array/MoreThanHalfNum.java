package com.bins.question.array;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/4/10 17:11
 * @apiNote 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum {


    /**
     * 题目描述：
     * 1.数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
     * 2.例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}
     * 3.由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2
     * 4.如果不存在则输出0
     *
     * @apiNote 思路：
     * 1.使用临时空间HashMap来解,key作为元素，value是当前元素出现次数
     * 2.一次遍历，先判断当前元素是否存在于map中，如果包含了，取出来，对value+1
     * 3.然后重新存进去，并且判断value也就是出现次数是否满足条件
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static int moreThanHalfNum(int[] nums) {
        //鲁棒
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int half = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
                if (count > half) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2};
        int[] nums1 = {1, 2, 2, 1, 1, 1};
        int[] nums2 = {1};
        int[] nums3 = {2, 2, 2, 2, 2};
        int[] nums4 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums5 = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(moreThanHalfNum(nums));
        System.out.println(moreThanHalfNum(nums1));
        System.out.println(moreThanHalfNum(nums2));
        System.out.println(moreThanHalfNum(nums3));
        System.out.println(moreThanHalfNum(nums4));
        System.out.println(moreThanHalfNum(nums5));
    }
}
