package com.bins.question.array;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/3/23 16:36
 * @apiNote 两个元素之和
 */
public class TwoSum {


    /**
     * 题目描述：
     * 1.给定一个整数数组 nums 和一个目标值 target
     * 2.请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 3.你可以假设每种输入只会对应一个答案。
     * 4.但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @apiNote 思路：
     * 1.首先暴力双重循环的话可以解题，但是时间复杂度太高了
     * 2.可以注意一个这样的特点：要求a+b=target，所以b=target-a
     * 3.所以，我们只要一次循环，在循环的过程中，只要用target减去数组中的每一个数，将结果b以及a的下标存放在哈希表中（key-value）
     * 4.每次都去哈希表中查找，看是否有元素等于b，等于b的话说明，这个当前的这个数满足等式，记录一下下标就行
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0 || nums.length == 1) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 11, 15, 6};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println(target + "=" + nums[result[0]] + "+" + nums[result[1]]);
        } else {
            System.out.println("没有找到");
        }
    }
}
