package com.bins.question.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/7/13 10:35
 * @apiNote 两个数组的交集Ⅱ
 * 来源：leetcode-350
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectⅡ {

    /**
     * 题目描述：
     * 1.给定两个数组，编写一个函数来计算它们的交集
     * <p>
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * <p>
     * 示例 2:
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * <p>
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 进阶:
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办
     *
     * @apiNote 思路：
     * 1.暴力+哈希表
     * 2.比第一版要难一点点，需要注意的是不能去重
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int n : nums1) {
            int c = map.getOrDefault(n, 1);
            map.put(n, c + 1);
        }
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                nums1[count++] = nums2[i];
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = nums1[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

}
