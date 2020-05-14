package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/4/18 17:13
 * @apiNote 盛最多水的容器
 */
public class MaxArea {


    /**
     * 题目描述：
     * 1.给你n个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
     * 2.在坐标内画n条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
     * 3.找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
     * 4.说明：你不能倾斜容器，且n的值至少为2
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(1)
     */
    public static int maxArea(int[] height) {
        int len = height.length;
        if (len <= 1) {
            return 0;
        }
        int tmp = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                int x = j - i;
                int y = height[i - 1] > height[j - 1] ? height[j - 1] : height[i - 1];
                tmp = Math.max(tmp, x * y);
            }
        }
        return tmp;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
