package com.bins.bishi.autumn2020.alibaba.event727;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/4 10:31
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.纸上写了一个单调非递减的数字序列，每个人依次选择一个数字
     * 2.然后把这个数字第一次出现位置及其之前的数字都删掉
     * 3.直到谁把序列删除空谁就赢了，
     * 4.niuniu先手，niumei后手，谁赢打印谁的名字。
     * <p>
     * 输入：
     * T 表示有几组数据
     * n 表示每组序列中有几个数
     * 接下来一行为序列
     * <p>
     * 样例：
     * 1
     * 6
     * 111222
     * 输出：niuniu
     * 原因：
     * niuniu选2，序列变为22；niumei选2，序列变为2；niuniu选2，序列变为空，niuniu赢
     * <p>
     * 额外测试用例：
     * 1，2，2，3：niuniu
     * 1，1，2：niuniu
     * 1，1，2，2：niumei
     * 1，2：niuniu
     *
     * @apiNote 思路：
     * 1.我们根据测试用例可以发现，从右边往走，只要某个数字出现的次数为奇数，那就一定是先手赢
     * 2.否则就是后手赢
     */
    public static void code(int[] nums) {
        int count = 1;
        int i = nums.length - 1;
        int first = nums[i];
        while (i > 0) {
            if (first == nums[i - 1]) {
                count++;
            } else {
                break;
            }
            i--;
        }
        System.out.println((count & 1) == 1 ? "niuniu" : "niumei");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        code(nums);
    }
}
