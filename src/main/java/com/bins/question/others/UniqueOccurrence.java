package com.bins.question.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author leo-bin
 * @date 2020/10/28 16:00
 * @apiNote 独一无二的出现次数
 * 来源：leetcode-1207
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class UniqueOccurrence {

    /**
     * 题目描述：
     * 1.给你一个整数数组arr，请你帮忙统计数组中每个数的出现次数
     * 2.如果每个数的出现次数都是独一无二的，就返回 true；否则返回false
     * <p>
     * 示例1：
     * 输入：arr=[1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1出现了3次，2出现了2次，3只出现了1次。没有两个数的出现次数相同
     * <p>
     * 示例2：
     * 输入：arr=[1,2]
     * 输出：false
     * <p>
     * 示例 3：
     * 输入：arr=[-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     * <p>
     * 提示：
     * 1<=arr.length<=1000
     * -1000<=arr[i]<=1000
     *
     * @apiNote 思路：
     * 1.暴力+hash表
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }
            set.add((int) entry.getValue());
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3,3};
        System.out.println(uniqueOccurrences(arr));
    }
}
