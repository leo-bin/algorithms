package com.bins.question.math;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/7 17:50
 * @apiNote 三角形的最大周长
 * 来源：leetcode-976
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle/
 */
public class LargestPerimeter {

    /**
     * 题目描述：
     * 1.给定由一些正数（代表长度）组成的数组 A
     * 2.返回由其中三个长度组成的、面积不为零的三角形的最大周长
     * 3.如果不能形成任何面积不为零的三角形，返回 0
     * <p>
     * 示例 1：
     * 输入：[2,1,2]
     * 输出：5
     * <p>
     * 示例 2：
     * 输入：[1,2,1]
     * 输出：0
     * <p>
     * 示例 3：
     * 输入：[3,2,3,4]
     * 输出：10
     * <p>
     * 示例 4：
     * 输入：[3,6,2,3]
     * 输出：8
     * <p>
     * 提示：
     * 3 <= A.length <= 10000
     * 1 <= A[i] <= 10^6
     *
     * @apiNote 思路：
     * 1.首先是三角形的定义：任意两边之和大于第三边（不能等于）
     * 2.这里如果我们要用暴力无脑去做的话，可以这样做
     * 3.首先穷举出所有三角形的组合数。
     * 4.然后从所有组合数中找和最大
     * 5.因为是三条边的组合，所有迭代的时间复杂度起码是：O(n*n*n)
     * 6.回溯当然也可以，但是实际耗时应该是一样的
     * 7.然后我们可以想着优化
     * 8.我们从周长最大入手，要想周长最大，边肯定要大，那就先排序
     * 9.排序完之后从最大的边开始找满足三角形定义的三条边
     * 10.到这里你可能会想，我还是需要找三条边呀，那岂不是还是需要三重循环？
     * 11.不！仔细观察可以发现，当我们从最后开始往前面遍历的时候，边的值是递减的。
     * 12.比如说：原数组是：[3，6，2，3],排序之后是：[2，3，3，6]
     * 13.我们直接按照相邻的关系顺序找这三条边！{3，3，6}，对应为：{a,b,c}
     * 14.其实只要满足a+b>c此时的三边就是一个三角形！不需要打乱顺序去判断a，b，c的其他组合了
     * 15.因为a和b永远小于c，其他的组合直接就可以排除了！
     * 16.时间复杂度：O(n*(log(n)))
     * 17.空间复杂度：O(1)
     */
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            int c = A[i - 2];
            int b = A[i - 1];
            int a = A[i];
            if (a + b > c) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}