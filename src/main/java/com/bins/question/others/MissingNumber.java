package com.bins.question.others;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/5/14 10:27
 * @apiNote 数组中缺失的数字
 * 来源：leetcode-268
 * 链接：https://leetcode-cn.com/problems/missing-number
 */
public class MissingNumber {


    /**
     * 题目描述：
     * 1.给定一个包含 0, 1, 2, ..., n 中 n 个数的序列
     * 2.找出 0 .. n 中没有出现在序列中的那个数
     * <p>
     * 示例 1:
     * 输入: [3,0,1]
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     * <p>
     * 示例3：
     * 输入：[0,1]
     * 输出：[2]
     * <p>
     * 示例4：
     * 输入：[0]
     * 输出：[1]
     * <p>
     * 示例5：
     * 输入：[1]
     * 输出：[0]
     *
     * @apiNote 思路：
     * 1.这道题有多种解法
     * 2.首先我们第一种可以想到的就是哈希表的解法，根据数组的大小生成了一个0-n的序列存哈希表
     * 3.然后只需要一次遍历去哈希表中找对应的数字就行，找到一个就删一个
     * 4.剩下的肯定就是缺的那个，时间复杂度：O(n),空间复杂度：O(n)
     * 5.我们可以进一步优化空间，可以采用解法二
     * 6.我们可以先一次排序，Arrays.sort(nums)
     * 7.然后一次遍历，找差值大于1的数字，返回这个数字+1就行，但是需要考虑到缺失的数字就是最后一个n的情况
     * 8.时间复杂度：O(n*log(n)),空间复杂度：O(1)
     * 9.你以为就这样结束了?不！还有更优雅的解法！
     * 10.我们仔细思考下，可以发现这道题还可以使用异或的思想！
     * 11.假设给我们的序列A=[3,0,1],完整的序列是：B=[0,1,2,3]
     * 12.我只要将A中的所有数字和B中的所有数字进行异或，得到的结果就是缺失的数字！
     * 13.3^3^0^0^1^1^2=2
     * 14.时间复杂度：O(n)
     * 15.空间复杂度：O(1)
     */
    public static int missingNumber(int[] nums) {
        //1.这里使用原始序列中的最后一个数字作为初始值
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= i;
        }
        //2.返回结果
        return xor;
    }


    /**
     * 解法二，原地遍历
     */
    public static int missingNumberV2(int[] nums) {
        //1.鲁棒
        if (nums.length == 1 && nums[0] == 0) {
            return 1;
        }
        //2.先排序
        Arrays.sort(nums);
        //3.遍历求差值
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums[nums.length - 1] + 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums3 = {0, 1};
        int[] nums4 = {0};
        int[] nums5 = {1};
        System.out.println(missingNumber(nums1));
        System.out.println(missingNumber(nums2));
        System.out.println(missingNumber(nums3));
        System.out.println(missingNumber(nums4));
        System.out.println(missingNumber(nums5));
    }
}
