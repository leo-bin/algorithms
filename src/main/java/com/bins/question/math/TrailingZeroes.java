package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/9/8 9:21
 * @apiNote 阶乘后的零
 * 来源：leetcode-172
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 */
public class TrailingZeroes {

    /**
     * 题目描述：
     * 1.给定一个整数 n，返回 n! 结果尾数中零的数量
     * <p>
     * 示例 1:
     * 输入: 3
     * 输出: 0
     * 解释: 3! = 6, 尾数中没有零。
     * <p>
     * 示例 2:
     * 输入: 5
     * 输出: 1
     * 解释: 5! = 120, 尾数中有 1 个零.
     * <p>
     * 说明: 你算法的时间复杂度应为 O(log n)
     *
     * @apiNote 思路：
     * 1.这题如果没有时间的限制，那么直接就现求阶乘然后统计0的个数就行
     * 2.但是这样做的时间复杂度起码是O(n)级别的
     * 3.于是我们试着去找找规律
     * 4.1!=1  2!=1*2=2  3!=1*2*3=6  4!=1*2*3*4=24  5!=1*2*3*4*5=120 6!=1*2*3*4*5*6=720 ...
     * 5.我们可以看到要想结果中带0，那么乘法因子就一定要有5
     * 6.如果你再继续推下去，你会发现我们只需要统计乘法因子中有多少个5就行
     * 7.时间复杂度：O(log(n))
     * 8.空间复杂度：O(1)
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
