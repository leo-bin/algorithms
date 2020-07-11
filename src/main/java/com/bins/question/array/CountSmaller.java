package com.bins.question.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/7/11 16:12
 * @apiNote 计算右侧小于当前元素的个数
 * 来源：leetcode-315
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 */
public class CountSmaller {

    private static int[] temp;
    private static int[] counter;
    private static int[] indexes;

    /**
     * 题目描述：
     * 1.给定一个整数数组 nums，按要求返回一个新数组 counts
     * 2.数组 counts 有该性质：
     * 4.counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量
     * <p>
     * 示例:
     * 输入: [5,2,6,1]
     * 输出: [2,1,1,0]
     * 解释:
     * 5 的右侧有 2 个更小的元素 (2 和 1).
     * 2 的右侧仅有 1 个更小的元素 (1).
     * 6 的右侧有 1 个更小的元素 (1).
     * 1 的右侧有 0 个更小的元素
     *
     * @apiNote 思路：
     * 1.
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        temp = new int[len];
        counter = new int[len];
        indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    private static void mergeAndCountSmaller(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(nums, l, mid);
        mergeAndCountSmaller(nums, mid + 1, r);
        // 如果索引数组有序，就没有必要再继续计算了
        if (nums[indexes[mid]] > nums[indexes[mid + 1]]) {
            mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
        }
    }

    private static void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }
        // 左边出列的时候，计数
        for (int index = left, i = left, j = mid + 1; index <= right; index++) {
            if (i > mid) {
                indexes[index] = temp[j++];
            } else if (j > right) {
                indexes[index] = temp[i++];
                // 此时 j用完了，之前的数就和后面的区间长度构成逆序
                counter[indexes[index]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[index] = temp[i++];
                counter[indexes[index]] += (j - mid - 1);
            } else {
                indexes[index] = temp[j++];
            }
        }
    }


    public static void main(String[] args) {

    }
}
