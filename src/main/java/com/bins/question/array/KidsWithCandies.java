package com.bins.question.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/6/1 13:18
 * @apiNote 拥有最多糖果的孩子
 * 来源：leetcode-1431
 * 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class KidsWithCandies {

    /**
     * 题目描述：
     * 1.给你一个数组 candies 和一个整数 extraCandies
     * 2.其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * 3.对每一个孩子，检查是否存在一种方案
     * 4.将额外的 extraCandies个糖果分配给孩子们之后，此孩子有最多的糖果
     * 5注意，允许有多个孩子同时拥有最多的糖果数目
     * <p>
     * 示例 1：
     * 输入：candies = [2,3,5,1,3], extraCandies = 3
     * 输出：[true,true,true,false,true]
     * 解释：
     * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
     * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
     * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
     * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
     * <p>
     * 示例 2：
     * 输入：candies = [4,2,1,1,2], extraCandies = 1
     * 输出：[true,false,false,false,false]
     * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
     * <p>
     * 示例 3：
     * 输入：candies = [12,1,12], extraCandies = 10
     * 输出：[true,false,true]
     *
     * @apiNote 思路：
     * 1.儿童节快乐！
     * 2.暴力没什么好说的哈，快乐就完事了！
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        //特判
        if (candies.length == 0) {
            return result;
        }
        int max = -1;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] candies1 = {2, 3, 5, 1, 3};
        int extraCandies1 = 3;

        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 3;

        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;

        System.out.println(kidsWithCandies(candies1, extraCandies1));
        System.out.println(kidsWithCandies(candies2, extraCandies2));
        System.out.println(kidsWithCandies(candies3, extraCandies3));
    }
}
