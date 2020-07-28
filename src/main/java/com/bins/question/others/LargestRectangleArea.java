package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/5/30 14:50
 * @apiNote 柱状图中最大的矩形
 * 来源：leetcode-84
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    /**
     * 题目描述：
     * 1.给定 n 个非负整数，用来表示柱状图中各个柱子的高度
     * 2.每个柱子彼此相邻，且宽度为 1
     * 3.求在该柱状图中x，能够勾勒出来的矩形的最大面积
     * <p>
     * 示例:
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     *
     * @apiNote 思路：
     * 1.两边扩散法+暴力
     * 2.这题有点像那个盛水的容器，但是不同的是这里不是简单的求两个起始点就可以
     * 3.这里求的最大面积是需要判断出某个子区间能够构成的最大矩形面积
     * 4.我们可以一次遍历每一个柱子，分别从当前的柱子的左边和右边开始找第一个小于自己高度的柱子
     * 5.因为一个区间的矩形的最大值取决于这个区间中最小的那个柱子！
     * 6.时间复杂度：O(n*n)
     * 7.空间复杂度：O(1)
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxArea = 0, left, right, curHeight, width;
        for (int i = 0; i < heights.length; i++) {
            curHeight = heights[i];
            //1.从左边开始找
            left = i;
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            //2.从右边开始找
            right = i;
            while (right < heights.length-1 && heights[right + 1] >= curHeight) {
                right++;
            }
            width = right - left + 1;
            maxArea = Math.max(maxArea, curHeight * width);
        }
        return maxArea;
    }



    public static void main(String[] args) {

    }
}
