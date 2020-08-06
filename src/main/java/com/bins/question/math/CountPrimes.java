package com.bins.question.math;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/6 22:01
 * @apiNote 统计质数的个数
 * 来源：leetcode-204
 * 链接：https://leetcode-cn.com/problems/count-primes/
 */
public class CountPrimes {



    /**
     * 题目描述：
     * 1.统计所有小于非负整数 n 的质数的数量。
     * 2.质数又称素数
     * 3.一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
     * 4.例如：7只能被1和7整除，除此之外不能再被其他数字整除，7就是质数
     * <p>
     * 示例:
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
     *
     * @apiNote 思路：
     * 1.首先是暴力
     * 2.时间复杂度：O(n*n)
     * 3.空间复杂度：O(1)
     */
    public static int countPrimes(int n) {
        //特判
        if (n < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            count = flag ? count + 1 : count;
        }
        return count;
    }


    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.这里采取一种投机取巧的方式来进行排除
     * 2.通过找规律我们可以发现，如果2是一个质数，那么2*2=4，2*3=6，2*4=8.。。都不是质数
     * 3.同样的，3是一个质数，那么3*2=6，3*3=9。。。也够不是质数了
     * 4.这种方式的时间复杂度比较难算，大概是n*log级别的
     * 5.空间复杂度：O(1)
     */
    public static int countPrimesV2(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        //范围其实只要从i到sqrt(n)就够了
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                //排除是2的倍数的数字
                for (int j = 2 * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        //统计剩下的质数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimesV2(n));
    }
}
