package com.bins.question.others;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/30 17:45
 * @apiNote 下一个排列
 * 来源：leetcode-31
 * 链接：https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {

    /**
     * 题目描述：
     * 1.实现获取下一个排列的函数
     * 2.算法需要将给定数字序列重新排列成字典序中下一个更大的排列
     * 3.如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
     * 4.必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * @apiNote 思路：
     * 1.一开始如果不看题目限制的话，可以直接暴力回溯求出所有组合，之后排序求对应位置的下一个位置就就行
     * 2.但是这里要求原地修改，不能使用额外的常数空间
     * 3.只好使用时间弥补空间
     * 4.这题本质上就是要我们求比当前序列刚好大一点的另一个序列
     * 5.假设序列是：[1，2，3]，比这个序列刚好大一点的序列就是：[1,3,2]
     * 6.可以看到我们只能从后面开始进行交换，如果从前面开始交换的话，整个数就会变的很大，无法求出大一点这个目的
     * 7.其次，有的时候我们还要考虑这种情况：[1，2，3，4，6，5]，我们交换4和5
     * 8.得到：[1,2,3,5,6,4],很明显，还有一个稍微大一点的序列就是：[1,2,3,5,4,6]
     * 9.也就是说经过我们的交换之后，必须要要满足交换位置之后的序列变成一个升序序列
     * 10.这里根据上面提到的要求，我们从后面开始遍历
     * 11.让当前的值和前一个位置的值进行比较，一旦后面的大于前面的，那就说明可以交换了
     * 12.但是这里是在交换之前先从当前的位置开始-len先进行一次排序
     * 13.然后从当前位置开始到len找可以交换的元素
     * 14.时间复杂度：O(n*log(n))
     * 15.空间复杂度：O(1)
     */
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //先进行局部排序
                Arrays.sort(nums, i, nums.length);
                //接着从当前位置到最后找需要交换的位置
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        //交换并返回
                        int t = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = t;
                        return;
                    }
                }
            }
        }
        //最后一个直接升序返回
        Arrays.sort(nums);
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
