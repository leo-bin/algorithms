package com.bins.question.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/6/27 11:57
 * @apiNote 数组中重复的数据
 * 来源：leetcode-442
 * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 */
public class FindDuplicates {

    /**
     * 题目描述：
     * 1.给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）
     * 2.其中有些元素出现两次而其他元素出现一次。
     * 3.找到所有出现两次的元素
     * 4.你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     * <p>
     * 示例：
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [2,3]
     *
     * @apiNote 思路：
     * 1.如果没有最后的条件限制，那这题非常简单，用哈希表做contains判断就行，但是O(n)空间不行
     * 2.这里继续采用之前做过的一道题，我们可以利用原来的数组给我们做额外的空间
     * 3.也就是使用原地hash的思想
     * 4.不同的是，我们需要判断出现了两次的数
     * 5.这里大家其实不用想太多，因为当你原地hash之后，重复出现的元素只会在一开始就出现一次
     * 6.然后后面出现的时候你只需要判断现在这个位置的元素和之前出现的过的元素的下标不一致，但是元素却是相同的
     * 7.相当于我们利用原数组实现了一个部分区域的哈希表，只有出现过一次的元素才会出现在这个区域中
     * 8.剩下的，我们就只需要利用这个哈希表来判断是否存在，从而来判断出现次数！
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(1)
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //1.原地hash，构造一个局部哈希表
        for (int i = 0; i < nums.length; i++) {
            //不越界并且不在对应的位置，那就交换，直到位置正确为止
            while (nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        //2.通过构造的哈希表来判断元素出现次数
        for (int i = 0; i < nums.length; i++) {
            if ((i != nums[i] - 1) && nums[i] == nums[nums[i] - 1]) {
                result.add(nums[i]);
            }
        }
        return result;
    }


    /**
     * 交换数组中两个元素
     */
    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = findDuplicates(nums);
        System.out.println(result.toString());
    }
}
