package com.bins.bishi.autumn2020.jingdong.practice;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/6 10:49
 * @apiNote
 */
public class Main5 {

    /**
     * 题目描述：
     * 1.小明同学学习了不同的进制之后，拿起了一些数字做起了游戏
     * 2.小明同学知道，在日常生活中我们最常用的是十进制数
     * 3.而在计算机中，二进制数也很常用
     * 4.现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)
     * 5. f(x)表示把x这个数用十进制写出后各个数位上的数字之和
     * 6.如f(123)=1+2+3=6
     * 7.g(x)表示把x这个数用二进制写出后各个数位上的数字之和
     * 8.如123的二进制表示为1111011，那么，g(123)=1+1+1+1+0+1+1=6
     * 9.小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数称为幸运数
     * 10.现在他想知道，大于0且小于等于n的幸运数有多少个？
     * <p>
     * 输入描述:
     * 每组数据输入一个数n(n<=100000)
     * <p>
     * 输出描述:
     * 每组数据输出一行，小于等于n的幸运数个数
     * <p>
     * 示例1
     * 输入
     * 21
     * <p>
     * 输出
     * 3
     *
     * @apiNote 思路：
     * 1.先暴力做吧，没啥思路，这个题目的测试用例好像不是很变态
     * 2.看看能过多少
     * 3.ok，还不错，一次过，还挺快
     * 4.时间复杂度：O(n*x)(其实应该是：O(n*x*32) n是x的位数，32是二进制的位数)
     * 5.空间复杂度：O(1)
     */
    public static boolean code(int x) {
        return fx(x) == gx(x);
    }

    /**
     * 计算fx,十进制各位之和
     */
    public static int fx(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }


    /**
     * 计算gx，二进制各位之和
     */
    public static int gx(int x) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((x & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int x = 1; x <= n; x++) {
            if (code(x)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
