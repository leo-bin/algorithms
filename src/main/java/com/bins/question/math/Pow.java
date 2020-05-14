package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/4/28 16:44
 * @apiNote 任意数的n次方
 */
public class Pow {


    /**
     * 题目描述:
     * 1.给定一个double类型的浮点数base和int类型的整数exponent
     * 2.求base的exponent次方
     * 3.保证base和exponent不同时为0
     * <p>
     * 测试用例：
     * base  exponent result
     * 2.0   2        4.0
     * 0.0   2        0.0
     * -2.0   2        4.0
     * -2.0   3       -8.0
     * 2.0  -2        0.25
     *
     * @apiNote 思路：
     * 1.使用递归+快速幂的方式
     * 2.一定要看清楚题目
     * 3.考虑到所有的情况
     * 4.base可能为负数，可能是小数,exponent也可能是负数
     * 5.关于快速幂，我们可以假设求2^64，普通方式可以怎么求？简单，循环63次呗
     * 6.但是这样效率比较低
     * 7.我们其实可以这样，先求，2^1 -> 2^2 -> 2^4 -> 2^8 -> 2^16 -> 2^32 -> 2^64
     * 8.这样一来，就将原来的63次计算缩小到了6次！
     * 9.但是这只是偶数的情况，如果是奇数的话，假设是求2^77
     * 10.我们可以求2^1 -> 2^2 -> 2^4 -> 2^9 -> 2^19 -> 2^38 -> 2^77
     * 11.咦？为啥是2^9而不像上面那样求2^8呢?虽然结果是正确的，但是很难看出来这个规律
     * 12.其实不是，如果我们从右往左去计算的话，你就会发现
     * 13.因为77是奇数，所以（2^38）^2之后还需要*2，如果是偶数，则不用结果就是(2^38)^2
     * 14.时间复杂度：O(log(n))
     * 15.空间复杂度：O(log(n))
     */
    public static double pow(double base, int exponent) {
        //鲁棒+提前预判
        if (exponent == 0) {
            return 1.0;
        }
        if (base == 0.0) {
            return 0.0;
        }
        return exponent > 0 ? powHelper(base, exponent) : 1.0 / powHelper(base, -exponent);
    }


    /**
     * 递归求幂次方
     */
    public static double powHelper(double base, long exponent) {
        //1.递归结束条件
        if (exponent == 0) {
            return 1.0;
        }
        double result = powHelper(base, exponent / 2);
        //奇数的话多乘一个base，偶数不用
        return (exponent & 1) == 1 ? result * result * base : result * result;
    }


    public static void main(String[] args) {
        double base = 2.0;
        int exponent = 10;
        System.out.println(pow(base, exponent));
    }
}
