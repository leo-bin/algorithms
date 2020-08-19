package com.bins.question.others;

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

    private static long sum = 0;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        code(nums);
        System.out.println(sum);
    }
}
