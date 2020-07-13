package com.bins.question.array;

import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/7/13 9:57
 * @apiNote 两个数组的交集 Ⅰ
 * 来源：leetcode-349
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Intersect {

    /**
     * 题目描述：
     * 1.给定两个数组，编写一个函数来计算它们的交集
     * <p>
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     * <p>
     * 示例 2：
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * <p>
     * 说明：
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序
     *
     * @apiNote 思路：
     * 1.暴力+hash表
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                nums1[count++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nums1[i];
        }
        return result;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.上面那个暴力真的太没技术含量了
     * 2.md，偷偷看了官方题解，发现原来还没我写的好。。。
     * 3.官方的解法是直接调api
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(n)
     */
    public static int[] intersectionV2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (int n : set1) {
            result[i++] = n;
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
