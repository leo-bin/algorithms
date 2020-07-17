package com.bins.bishi.spring2020.bianlifeng;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/10 19:53
 * @apiNote
 */
public class code3 {


    /**
     * 题目描述：
     * 1.你现在负责便利蜂的运输工作，现在需要把一批货物从起点的门店送到位于终点的门店
     * 2.运送方式是使用每个门店自有的一辆车，由于每个门店车辆的油量不同导致可行驶距离不同，可能需要你在中途门店换车接力运送
     * 3.例如，各门店自行车的距离是1,4,1,1,2,0,5，则最少需要 3 辆车到达
     * 4.分析：从第一个门店（位置0）使用第1辆车出发，行进1的距离到达第二个门店（位置1）
     * 5.换乘可以行进4个距离的第2辆车，前进3个位置到达倒数第三个门店,
     * 6.换乘可行进2个距离的第3辆车，前进2个位置到达终点
     * <p>
     * 输入
     * 输入为一个门店数组，每个元素（非负整数）为该位置的门店车辆可以行进的 最远距离。
     * <p>
     * 输出
     * 需要你输出从起点（第0个元素）出发到达位于最后一个位置的门店最少需要使用几辆车， 如果无法到达返回-1。
     * <p>
     * 样例输入
     * 1,4,1,1,2,0,5
     * <p>
     * 样例输出
     * 3
     *
     * @apiNote 思路：
     * 1.dp
     */
    public static int minCount(int[] nums) {
        //鲁棒
        if (nums.length < 1) {
            return -1;
        }
        if (nums[0] == 0) {
            return -1;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;
        int flag = 0;
        int index = 0;
        for (int i = 2; i <= len; i++) {
            int count = nums[index];
            for (int j = flag; j <= count; j++) {
                if (nums[j + 1] > 0) {
                    flag++;
                }
            }
            if (nums[i - 2] > 0 && flag == (i - 1)) {
                dp[i] = dp[i - 1] + 1;
                //换了辆车
                index++;
            } else {
                //没换车
                dp[i] = dp[i];
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.valueOf(strs[i]);
        }
        System.out.println(minCount(nums));
    }
}
