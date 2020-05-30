package com.bins.question.others;

/**
 * @author leo-bin
 * @date 2020/4/18 17:13
 * @apiNote 盛最多水的容器
 * 来源：leetcode-11
 * 链接：https://leetcode-cn.com/problems/container-with-most-water/solution/
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


    /**
     * 解法二，双指针
     *
     * @apiNote 思路：
     * 1.双指针思想
     * 2.根据暴力的思想我们可以知道，某个区域的最大面积一定为maxArea=min(height[i],height[j])*(j-i)
     * 3.而我们之前的做法就是把所有的情况都算出来，但是其实我们可以通过设置两个头尾指针来提高这种解法
     * 4.设置i为头指针指向数组第一个元素，j为尾指针指向数组最后一个元素
     * 5.先通过公式算出此时的maxArea
     * 6.然后此时移动i或者j
     * 7.如果此时的maxArea=height[i]*(j-i),那么就移动i++
     * 8.如果此时的maxArea=height[j]*(j-i),那就移动j--
     * 9.通俗点来说就是移动短板所在的指针！
     * 10.至于为什么得出这样的规律我们可以分析一下
     * 11.如果移动长板的话，那么接下来得出的短板的长度会不变或者变小，那么此时的面积一定会变小的
     * 12.如果移动短板的话，那么接下类得出的短板的长度可能会变大！很明显面积可能会变大！
     * 13.时间复杂度：O(n)
     * 14.空间复杂度：O(1)
     */
    public static int maxAreaV2(int[] height) {
        int i = 0, j = height.length - 1, max = 0, cur;
        while (i < j) {
            cur = height[i] < height[j] ? (j - i) * height[i++] : (j - i) * height[j--];
            max = Math.max(max, cur);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxAreaV2(height));
    }
}
