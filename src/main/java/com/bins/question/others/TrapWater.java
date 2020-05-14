package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/4/30 11:44
 * @apiNote 接雨水
 * 来源：leetcode-42
 * 级别：hard
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrapWater {


    /**
     * 题目描述：
     * 1.给定 n 个非负整数表示每个宽度为 1 的柱子的高度图
     * 2.计算按此排列的柱子，下雨之后能接多少雨水。
     * 3.上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图
     * 4.在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
     * <p>
     * 示例:
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(1)
     */
    public static int trapWater(int[] height) {
        //鲁棒
        if (height.length <= 2) {
            return 0;
        }
        int sumWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //找左边最高的
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            //找右边最高的
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }
            //选最矮的
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sumWater += (min - height[i]);
            }
        }
        return sumWater;
    }



    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height1 = {5, 4, 1, 2};
        int[] height2 = {2, 1, 0, 2};
        int[] height3 = {5, 2, 1, 2, 1, 5};
        int[] height4 = {4, 2, 0, 3, 2, 5};
        System.out.println(trapWater(height));
        System.out.println(trapWater(height1));
        System.out.println(trapWater(height2));
        System.out.println(trapWater(height3));
        System.out.println(trapWater(height4));
    }
}
