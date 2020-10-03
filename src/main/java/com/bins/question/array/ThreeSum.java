package com.bins.question.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/3/23 16:36
 * @apiNote 三个元素之和
 * 来源：leetcode-15
 * 链接：https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * 题目描述：
     * 1.给你一个包含 n 个整数的数组 nums
     * 2.判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
     * 3.请你找出所有满足条件且不重复的三元组
     * 4.答案中不可以包含重复的三元组
     * <p>
     * 示例：
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     *
     * @apiNote 思路：
     * 1.我们可以找到这样一个公式：-a=(b+c)
     * 2.也就是说我们只要一次大循环，每次固定一个数，a=-nums[i]
     * 3.同时使用双指针，通过不断的判断范围来确定是否有a=（nums[left]+nums[right]）
     * 4.有的话就存结果
     * 5.考虑到会有重复的组合结果，所以每次存的时候都先判断下当前的结果是否已经存过了（这里使用HashSet来实现去重）
     * 6.时间复杂度：O(n*n)
     * 7.空间复杂度：O(n)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 2) {
            return result;
        }
        //先排序
        Arrays.sort(nums);
        //定义两个指针：left,right，分别指向左边和右边
        int a, left, right;
        //使用HashSet来判断是否有重复的组合
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            a = -nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (a == (nums[left] + nums[right])) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(-a);
                    tmp.add(nums[left++]);
                    tmp.add(nums[right--]);
                    //去重
                    if (!set.contains(tmp)) {
                        set.add(tmp);
                        result.add(tmp);
                    }
                } else if (a > (nums[left] + nums[right])) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.toString());
    }
}
