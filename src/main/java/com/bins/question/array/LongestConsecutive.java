package com.bins.question.array;

import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/6/6 10:31
 * @apiNote 最长连续序列
 * 来源：leetcode-128
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive {


    /**
     * 题目描述：
     * 1.给定一个未排序的整数数组
     * 2.找出最长连续序列的长度
     * 3.要求算法的时间复杂度为 O(n)
     * <p>
     * 示例:
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4
     *
     * @apiNote 思路：
     * 1.因为是无序的，首先想到排序，但是限制时间复杂度为O(n
     * 2.目前我所知道的排序算法比较方便实现的最快也是快排和堆排，都是n*log(n)级别的
     * 3.那就不用考虑排序了。
     * 4.那这里就是用空间换时间，用哈希表来做
     * 5.先把所有元素存Set集合，便于去重
     * 6.然后一次遍历数组，遍历的同时分别从当前元素的左边和右边开始找连续的数
     * 7.找到的同时将元素从set中删掉
     * 8.时间复杂度：O(n)(虽然for里面套了两个while循环，但是实际上总体的循环次数就是n)
     * 9.空间复杂度：O(n)
     */
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int cur;
        for (int n : nums) {
            set.add(n);
        }
        for (int n : nums) {
            if (set.remove(n)) {
                //1.从当前元素的左边开始找：n-1,n-2,n-3...
                cur = n;
                int curMax = 1;
                while (set.remove(cur - 1)) {
                    cur--;
                }
                //算长度
                curMax += (n - cur);
                //2.从当前元素的右边开始找：n+1,n+2,n+3...
                cur = n;
                while (set.remove(cur + 1)) {
                    cur++;
                }
                //算长度
                curMax += (cur - n);
                //更新最长的
                max = Math.max(curMax, max);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums1 = {0, 0, -1};
        int[] nums2 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
    }
}
