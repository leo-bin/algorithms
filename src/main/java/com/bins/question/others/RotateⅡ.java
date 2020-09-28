package com.bins.question.others;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/9/28 16:03
 * @apiNote 旋转数组
 * 来源：leetcode-189
 * 链接：https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateⅡ {

    /**
     * 题目描述：
     * 1.给定一个数组，将数组中的元素向右移动 k 个位置
     * 2.其中k是非负数
     * <p>
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * <p>
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题
     * 要求使用空间复杂度为 O(1) 的 原地 算法
     *
     * @apiNote 思路：
     * 1.既然规定了空间复杂度，那么 就不能使用额外的空间了
     * 2.这里需要对原数组进行多次交换才能达到旋转的效果
     * 3.一种最简单的方法就是每次确定一个元素，然后从当前元素开始的后面的所有元素都往后面移动
     * 4.时间复杂度：O(n*k)
     * 5.空间复杂度：O(1)
     */
    public static void rotate(int[] nums, int k) {
        int pre;
        for (int i = 0; i < k; i++) {
            pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int t = nums[j];
                nums[j] = pre;
                pre = t;
            }
        }
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.我们尝试优化下时间
     * 2.假设原数组是：{1，2，3，4，5，6，7}
     * 3.如果我们先将整个数组都反转就会得到：{7，6，5，4，3，2，1}
     * 4.然后我们再次将前面k个元素进行反转就会得到：{5，6，7，4，3，2，1}
     * 5.最后我们只需要将后面n-k个元素也都反转就会得到：{5，6，7，1，2，3，4}就是我们想要的结果啦
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static void rotateV2(int[] nums, int k) {
        //防止k超过数组的长度
        k %= nums.length;
        //反转0-n
        reverse(nums, 0, nums.length - 1);
        //反转前k个
        reverse(nums, 0, k-1);
        //反转后面n-k个
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 反转数组的局部
     */
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateV2(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
