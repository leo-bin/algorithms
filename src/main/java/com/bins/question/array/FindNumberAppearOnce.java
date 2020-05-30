package com.bins.question.array;


/**
 * @author leo-bin
 * @date 2020/4/26 17:38
 * @apiNote 数组中只出现1次的数
 * 来源：leetcode-136
 * 链接：https://leetcode-cn.com/problems/single-number/
 */
public class FindNumberAppearOnce {


    /**
     * 题目描述：
     * 1.一个整型数组里除了1个数字之外，其他的数字都出现了两次
     * 2.请写程序找出这1个只出现一次的数字
     * 3.array={1,2,3,2,3}
     *
     * @apiNote 思路：
     * 1.异或思想
     * 2.1^2^3^2^3  => (2^2)^(3^3)^1  =>  0^0^1=1
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(1)
     */
    public static int findNumberAppearOnce(int[] array) {
        //鲁棒
        if (array.length == 0) {
            return -1;
        }
        int xorSum = 0;
        for (int i = 0; i < array.length; i++) {
            xorSum ^= array[i];
        }
        return xorSum;
    }


    public static void main(String[] args) {
        int[] array = {1, 1, 2, 4, 4};
        System.out.println(findNumberAppearOnce(array));
    }
}
