package com.bins.bishi.autumn2020.qunaer;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/23 18:05
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 2020年，直播已经成为去哪儿网酒店预售的新武器
     * 去哪儿网CEO刚哥想从公司的m名员工中挑选n名参与自己的直播
     * 已知m小于100请问一共有多少种选法
     * <p>
     * 输入描述
     * m（公司员工数）
     * n （挑选的员工数）
     * <p>
     * 输出描述
     * p(挑选方法)
     * <p>
     * 样例输入
     * 4
     * 2
     * 样例输出
     * 6
     *
     * @apiNote 思路：
     * 1.求阶乘问题，递归解决
     * 2.ac了36%，肯定是溢出了
     * 3.原来是求大阶乘的时候溢出了，就算使用long也溢出了
     * 4.一种可行的办法就是在计算小阶乘的时候进提前进行约分
     * 5.这里采用另一种比较取巧的方法，直接使用jdk自带的BigInteger进行运算
     */

    /**
     * n的阶乘
     */
    private static BigInteger one = new BigInteger(1 + "");

    public static BigInteger fac(BigInteger n) {
        if (n.intValue() <= 1) {
            return one;
        }
        return n.multiply(fac(n.subtract(one)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        //特判
        if (m <= 0 || n <= 0) {
            System.out.println(0);
        } else if (m < n) {
            System.out.println(0);
        } else if (m == n) {
            System.out.println(1);
        } else {
            BigInteger a = fac(new BigInteger(m + ""));
            BigInteger b = fac(new BigInteger(n + ""));
            BigInteger c = fac(new BigInteger((m - n) + ""));
            System.out.println(a.divide(b.multiply(c)));
        }
    }
}
