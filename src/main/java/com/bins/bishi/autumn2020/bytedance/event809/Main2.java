package com.bins.bishi.autumn2020.bytedance.event809;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/9 21:01
 * @apiNote
 */
public class Main2 {

    public static int maxSum = Integer.MIN_VALUE;

    public static int code(int[] nums) {
        backtrace(nums, 0, 0, 0);
        return maxSum;
    }

    public static void backtrace(int[] nums, int currentSum, int index, int count) {
        //更新最大值
        maxSum = Math.max(currentSum, maxSum);
        for (int i = index; i < nums.length; i++) {
            //保证连续
            if (i > index && (i - index) >= 1 && count >= 1) {
                continue;
            }
            int target = ((i + 1) & 1) == 1 ? nums[i] : -nums[i];
            currentSum += target;
            count++;
            backtrace(nums, currentSum, i + 1, count);
            currentSum -= target;
            count--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(code(nums));
    }
}
