package com.bins.bishi.autumn2020.meituan.bishi2017;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/28 11:59
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 1.给定一组非负整数组成的数组h，代表一组柱状图的高度
     * 2.其中每个柱子的宽度都为1
     * 3.在这组柱状图中找到能组成的最大矩形的面积（如图所示）
     * 4.入参h为一个整型数组，代表每个柱子的高度，返回面积的值。
     * <p>
     * 输入描述:
     * 输入包括两行,第一行包含一个整数n(1 ≤ n ≤ 10000)
     * 第二行包括n个整数,表示h数组中的每个值,h_i(1 ≤ h_i ≤ 1,000,000)
     * <p>
     * 输出描述:
     * 输出一个整数,表示最大的矩阵面积。
     * <p>
     * 输入例子1:
     * 6
     * 2 1 5 6 2 3
     * <p>
     * 输出例子1:
     * 10
     *
     * @apiNote 思路：
     * 1.我们依次枚举每一个给定的高度，让当前高度作为矩形的高，找到一个可能的最大的矩形
     * 2.怎么找？两边扩散！
     * 3.我们以当前高度为出发点，设置两个指针left和right分别从两边开始寻找
     * 4.一旦遇到比自己要小的高度就终止
     * 5.不理解可以想一下木桶原理，当然是找最短的短板。
     * 6.当两边都终止寻找之后，此时left和right就代表以当前高度作为最终高度的矩形的边界
     * 7.求出此时的面积，ok，现在只需要依次像这样遍历所有高度，找最大的面积就可。
     * 8.时间复杂度：O()
     * 9.空间复杂度：O(1)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int left = i;
            while (left > 0 && height[left - 1] >= height[i]) {
                left--;
            }

            int right = i;
            while (right < height.length-1 && height[right + 1] >= height[i]) {
                right++;
            }

            int curWidth = right - left + 1;
            maxArea = Math.max(maxArea, curWidth * height[i]);
        }
        System.out.println(maxArea);
    }
}
