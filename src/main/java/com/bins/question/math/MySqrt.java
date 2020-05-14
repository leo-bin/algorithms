package com.bins.question.math;

/**
 * @author leo-bin
 * @date 2020/5/9 16:16
 * @apiNote x的平方根
 * 来源：leetcode-69
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class MySqrt {


    /**
     * 题目描述：
     * 1.实现 int sqrt(int x)函数
     * 2.计算并返回 x 的平方根，其中x是非负整数
     * 3.由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
     * <p>
     * 示例 1:
     * 输入: 4
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * <p>
     * 说明:
     * 1.8 的平方根是 2.82842...
     * 2.由于返回类型是整数，小数部分将被舍去
     *
     * @apiNote 思路：
     * 1.api
     */
    public static int mySqrt(int x) {
        //return (int) Math.pow(x, 1.0 / 2);
        return (int) Math.sqrt(x);
    }


    /**
     * 解法二，二分法
     *
     * @apiNote 思路：
     * 1.其实我们还可以使用二分的思想来做这个题目
     * 2.根据题目的要求，是不需要我们求得一个非常精确的数字的
     * 3.也就是说假设x是8，按道理来说用计算器算下，8的平方根应该等于2.82842。。。，所以只要取2就行
     * 4.根据这一点，我们可以知道，我们要求的平方根的取值范围一定是在0~x内！
     * 5.并且我们可以自己推导下，这个x的平方根n一定满足：n^2<=x && (n+1)^2>x
     * 6.我们只要根据这个公式不断的缩小范围就行了
     * 7.这里使用二分的模板
     * 8.时间复杂度：O(log(n))
     * 9.空间复杂度：O(1)
     */
    public static int mySqrtV2(int x) {
        //鲁棒
        if (x == 0 || x == 1) {
            return x;
        }
        //使用long防止溢出
        long left = 1;
        long right = x;
        while (left < right) {
            //(left+right)>>>1就是求中位数，+1目的是为了求中位数时往后移一位，防止死循环
            long mid = (left + right + 1) >>> 1;
            long s = mid * mid;
            if (s > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }


    /**
     * 解法三，牛顿迭代法
     *
     * @apiNote 思路：
     * 1.不懂。。。
     */
    public static int mySqrtV3(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }


    public static void main(String[] args) {
        int x = 8;
        int x1 = 2;
        int x2 = 9;
        int x3 = 25;
        System.out.println("///////解法一/////////");
        /*System.out.println(mySqrt(x));
        System.out.println(mySqrt(x1));
        System.out.println(mySqrt(x2));
        System.out.println(mySqrt(x3));*/

        System.out.println("///////解法二/////////");
        System.out.println(mySqrtV2(x));
    }
}
