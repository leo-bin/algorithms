package com.bins.question.scale;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/6/4 10:09
 * @apiNote 除自身以外数组的乘积
 * 来源：leetcode-238
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class ProductExceptSelf {


    /**
     * 题目描述：
     * 1.给你一个长度为 n 的整数数组 nums，其中 n > 1
     * 2.返回输出数组 output
     * 3.其中 output[i]等于nums中除nums[i]之外其余各元素的乘积
     * <p>
     * 示例:
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * <p>
     * 提示：
     * 1.题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * 2.请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：
     * 1.你可以在常数空间复杂度内完成这个题目吗？
     * 2.（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     *
     * @apiNote 思路：
     * 1.这题一开始想简单了，我想直接算出全部元素的乘积之和
     * 2.然后一次遍历元素的同时用乘积之和去除每个元素
     * 3.但是没有考虑到用例中出现0的情况！！！
     * 4.这里参考官方的前缀和和后缀和的解法
     * 5.要找到除了某个元素之外的所有元素
     * 6.我们只需要求出这个元素的前缀乘积之和和后缀乘积之和然后两者相乘就行了。
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(n)
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int[] left = new int[len];
        //1.现求前缀乘积之和
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //2.接着求后缀乘积之和(反着求就行,这里服用了result数组代替后缀乘积之和)
        result[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        //3.前缀*后缀
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * result[i];
        }
        return result;
    }

    /**
     * 进一步优化空间复杂度
     *
     * @apiNote 思路：
     * 1.我们其实复用result数组
     * 2.先用result存前缀乘积之和
     * 3.然后使用一个变量R动态的生成后缀乘积之和数组
     * 4.同时算出结果
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static int[] productExceptSelfV2(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
