package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/6/4 12:19
 * @apiNote 两数相除
 * 来源：leetcode-29
 * 链接：https://leetcode-cn.com/problems/divide-two-integers/
 */
public class Divide {


    /**
     * 题目描述：
     * 1.给定两个整数，被除数 dividend 和除数 divisor
     * 2.将两数相除，要求不使用乘法、除法和 mod 运算符
     * 3.返回被除数 dividend 除以除数 divisor 得到的商。
     * 4.整数除法的结果应当截去（truncate）其小数部分
     * 5.例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * <p>
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * <p>
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     * <p>
     * 提示：
     * 1.被除数和除数均为 32 位有符号整数。
     * 2.除数不为 0。
     * 3.假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]
     * 4.本题中，如果除法结果溢出，则返回 2^31 − 1
     *
     * @apiNote 思路：
     * 1.这里限制不能使用乘除，我们就要从位运算还有加减的思路下手。
     * 2.一开始也没有想到什么好用的的位运算，本身就不是很熟悉。
     * 3.之后看到了一种解法觉得很牛批，很清晰。
     * 4.核心思想就是先比较a和b的值，如果a比b要大，a/b肯定要大于1。
     * 5.然后我们让b翻倍，b+b，再次比较a和b+b
     * 6.如果a还是大于b+b，那a/b的结果肯定要大于2。
     * 7.就这样比下去，直到a小于翻倍后的b。
     * 8.这里假设a=11，b=3
     * 9.第一轮比较：11>3,所以我们用count来记录此时的结果，现在count=1
     * 10.b翻倍，接着比较，11>6,count=2
     * 11.b再次翻倍，比较，11<12
     * 12.出现大于的情况，那就让11-6=5，我们从5开始继续比较
     * 13.5>3,count=1
     * 14.b翻倍，5<6,现在是5-3=2，但是此时的a<b,不用算了，肯定是个小数！
     * 15.有没有觉得很像递归的味道？
     * 16.最后就是需要注意int值的溢出问题。
     * 17.我们可以分情况讨论，做一个特判就行。
     * 18.时间复杂度：O(m*log(n))
     * 19.空间复杂度：O(n)
     */
    public static int divide(int dividend, int divisor) {
        //特判
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            //溢出了
            return Integer.MAX_VALUE;
        }
        //1.先求标志位
        int flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        //考虑下面再变成正数的时候会溢出，这里用long
        long a = dividend;
        long b = divisor;
        //都变正数
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        //2.递归求结果
        int res = divideHelper(a, b);
        //3.根据标志位返回结果
        return flag > 0 ? res : -res;
    }


    /**
     * 递归求商
     */
    public static int divideHelper(long a, long b) {
        //1.递归结束条件
        if (a < b) {
            return 0;
        }
        long tb = b;
        long count = 1;
        //这里做翻倍的时候也会溢出，所以用long
        while ((tb + tb) <= a) {
            //b和count都翻倍
            count += count;
            tb += tb;
        }
        //减掉tb再来一次
        return (int) count + divideHelper(a - tb, b);
    }


    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int a1 = -10;
        int b1 = 5;
        int a2 = 10;
        int b2 = -5;
        int a3 = 2147483647;
        int b3 = 2;
        System.out.println(a + "/" + b + "=" + divide(a, b));
        System.out.println(a1 + "/" + b1 + "=" + divide(a1, b1));
        System.out.println(a2 + "/" + b2 + "=" + divide(a2, b2));
        System.out.println(a3 + "/" + b3 + "=" + divide(a3, b3));
    }
}
