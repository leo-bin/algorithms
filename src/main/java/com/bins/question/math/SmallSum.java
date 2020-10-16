package com.bins.question.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/19 17:43
 * @apiNote 计算数组的小和
 * 来源：牛客
 * 链接：https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469?tpId=101&tqId=33089&tPage=1&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 */
public class SmallSum {

    /**
     * 解法一
     *
     * @apiNote 思路：
     * 1.其实题目很好理解，我们一个一个求就行
     * 2.但是难就难在这里限制了时间和空间复杂度
     * 3.但是刷题是一个学习的过程，目的并不是为了马上a出题
     * 4.我们应该尝试写出多种解法，多种可能，锻炼自己的coding能力
     * 5.那这里就先忽略时间和空间的限制，我们先用能够想到的最简单的暴力去写
     * 6.思路也很简单，一个元素一个元素的求呗
     * 7.时间复杂度：O(n*n)
     * 8.空间复杂度：O(1)
     */
    public static int codeV2(int[] nums) {
        int sum = 0;
        int current;
        for (int i = 0; i < nums.length; i++) {
            current = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] <= current) {
                    sum += nums[j];
                }
            }
        }
        return sum;
    }


    /**
     * 统计小和的个数
     */
    private static long sum = 0;

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.采用归并排序的思想，在归并的时候求小和，并统计个数
     * 2.
     */
    public static int[] code(int[] nums) {
        //递归结束条件
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(code(left), code(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length && j < right.length) {
                result[index] = right[j++];
            } else if (j >= right.length && i < left.length) {
                result[index] = left[i++];
            } else if (left[i] <= right[j]) {
                //计算小和
                sum += (right.length - j) * left[i];
                result[index] = left[i++];
            } else {
                result[index] = right[j++];
            }
        }
        return result;
    }


    /**
     * 题目描述:
     * 1.数组小和的定义如下：
     * 2.数组s=[1,3,5,2,4,6]，在s[0]的左边小于或等于s[0]的数的和为0
     * 3.在s[1]的左边小于或等于s[1]的数的和为1
     * 4.在s[2]的左边小于或等于s[2]的数的和为1+3=4
     * 5.在s[3]的左边小于或等于s[3]的数的和为1
     * 6.在s[4]的左边小于或等于s[4]的数的和为1+3+2=6
     * 7.在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15
     * 8.所以s的小和为0+1+4+1+6+15=27
     * 9.给定一个数组s，实现函数返回s的小和
     * 10.要求时间复杂度为O(n*log(n))，空间复杂度为O(n)
     * <p>
     * 输入描述:
     * 第一行有一个整数N。表示数组长度
     * 接下来一行N个整数表示数组内的数
     * <p>
     * 输出描述:
     * 一个整数表示答案
     * <p>
     * 示例:
     * 输入
     * 6
     * 1 3 5 2 4 6
     * 输出
     * 27
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        code(nums);
        System.out.println(sum);
        System.out.println(codeV2(nums));
    }
}
