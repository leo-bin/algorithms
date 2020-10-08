package com.bins.question.math;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/10/8 18:22
 * @apiNote 最大数
 * 来源：leetcode-179
 * 链接：https://leetcode-cn.com/problems/largest-number/
 */
public class LargestNumber {

    /**
     * 题目描述：
     * 1.给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数
     * 2.注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数
     * <p>
     * 示例 1：
     * 输入：nums = [10,2]
     * 输出："210"
     * <p>
     * 示例 2：
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * <p>
     * 示例 3：
     * 输入：nums = [1]
     * 输出："1"
     * <p>
     * 示例 4：
     * 输入：nums = [10]
     * 输出："10"
     * <p>
     * 提示：
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 10^9
     *
     * @apiNote 思路：
     * 1.自定义降序即可
     * 2.既然是求最大值，我们可以观察到只要将那些数字中的高位是最大值的元素放到前面，最后出来的肯定是最大值
     * 3.比如说：[10,2],按照比较元素的高位来看，显然2的高位是2，10的高位是1，所以2>10
     * 4.但是也许要考虑到一种特殊情况：[3,30],这种情况我们没法通过直接比较高位来判断大小
     * 5.但是我们可以先进行组合，看结果即可，因为330>303的，所以3>30
     * 6.这一点我们可以通过将所有元素转成String，之后使用Arrays.sort排序方法，并重写比较器即可实现
     * 7.最后考虑一种特殊情况:[0,0,0,0],很显然，最后的结果是:0，但是我们算出来的却是"0000"
     * 8.时间复杂度：O(n*log(n))
     * 9.空间复杂度：O(n)
     */
    public static String largestNumber(int[] nums) {
        //特判
        if (nums == null || nums.length <= 0) {
            return "";
        }
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        //自定义降序排序：s1+s2和s2+s1
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder builder = new StringBuilder();
        for (String string : s) {
            builder.append(string);
        }
        //处理都是0的情况（只留一个0）
        if (builder.charAt(0) == '0') {
            return "0";
        } else {
            return builder.toString();
        }
    }


    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
