package com.bins.question.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/7/22 9:16
 * @apiNote 找到数组中所有消失的数字
 * 来源：leetcode-448
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindDisappearedNumbers {

    /**
     * 题目描述：
     * 1.给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组
     * 2.数组中的元素一些出现了两次，另一些只出现一次
     * 3.找到所有在 [1, n] 范围之间没有出现在数组中的数字
     * 4.您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
     * 5.你可以假定返回的数组不算在额外空间内
     * <p>
     * 示例:
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     *
     * @apiNote 思路：
     * 1.啥都不管，暴力+哈希表就是干
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static List<Integer> findDisappearedNumders(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.利用题目给出的特点，数组中的元素一定是在1到nums.length之间
     * 2.所以我们只需遍历每一个元素，去数组中找下标等于当前元素的值，然后置为负数
     * 3.遍历完之后，剩下的还是为正数的元素，它们此时的下标就是我们要找的元素
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static List<Integer> findDisappearedNumbersV2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        //找依旧是正数的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
