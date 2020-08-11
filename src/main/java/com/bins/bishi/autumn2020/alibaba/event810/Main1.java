package com.bins.bishi.autumn2020.alibaba.event810;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/10 17:45
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述
     * 一条直线道路上有N棵树，现要在这条道路上某个位置修建水塔
     * 要求这N棵树所在的位置坐标到水塔的位置坐标总距离最短
     * 请求出水塔位置坐标。（所有位置坐标均为整数。）
     * <p>
     * 输入描述:
     * 第一行一个整数N。
     * 第二行共N个整数a_1，a_2，...，a_N表示N棵树的坐标
     * ​
     * 输出描述:
     * 一个整数，表示最短总距离
     * <p>
     * 示例1
     * 输入
     * 4
     * 0 1 4 6
     * <p>
     * 输出
     * 9
     * 说明
     * 可选择位置3处建水塔，总距离为3+2+1+3=9最短
     *
     * @apiNote 思路：
     * 1.先考虑暴力，
     * 2.暴力肯定超时，只过了30，接着考虑优化
     * 3.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        /*for (int pos = nums[0]; pos <= nums[N - 1]; pos++) {
            int sum = 0;
            for (int target : nums) {
                if (pos >= target) {
                    sum += pos - target;
                } else {
                    sum += target - pos;
                }
            }
            min = Math.min(sum, min);
        }*/
        min = code(nums);
        System.out.println(min);
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.突然意识到这题就是一个找中位数的问题。。。
     * 2.直接排序之后根据数组的长度判断奇偶数就行了
     * 3.时间复杂度：O(n*(log(n)))
     */
    public static int code(int[] nums) {
        int sum = 0;
        int pos = nums.length / 2;
        for (int target : nums) {
            if (pos >= target) {
                sum += pos - target;
            } else {
                sum += target - pos;
            }
        }
        return sum;
    }
}

