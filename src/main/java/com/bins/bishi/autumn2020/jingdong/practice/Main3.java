package com.bins.bishi.autumn2020.jingdong.practice;


/**
 * @author leo-bin
 * @date 2020/8/5 11:41
 * @apiNote
 */
public class Main3 {

    /**
     * 解法一，暴力
     *
     * @apiNote 思路：
     * 1.首先根据题意，数据量不多，就算是最多的就是9
     * 2.所以这里可以可以暴力过
     * 3.暴力的过程就是题目的模拟过程
     */
    public static int code1(int n) {
        for (int i = n + 1; ; i++) {
            int apple = i;
            int count = n;
            while (count > 0) {
                if (apple % n == 1) {
                    apple -= (apple / n) + 1;
                    count--;
                } else {
                    break;
                }
            }
            if (count == 0) {
                return i;
            }
        }
    }


    /**
     * 解法二，贪心
     *
     * @apiNote 思路：
     * 1.这里有点数学的味道了
     * 2.如果你仔细观察，就可以发现，假设苹果有x个
     * 3.每次都要从x中分n个出去，而且还要多丢一个
     * 4.那我们这样去想，假设不丢那一个，x就等于=n^n个
     * 5.但是题目要求丢，分了n次，最后一次可以不分，所以这n次中总共丢了n-1个
     * 6.所以我们的x等于=n^n-n+1
     */
    public static int code2(int n) {
        return (int) (Math.pow(n, n) - n + 1);
    }

    /**
     * 题目描述：
     * 1.果园里有一堆苹果，一共n头(n大于1小于9)熊来分
     * 2.第一头为小东，它把苹果均分n份后，多出了一个，它扔掉了这一个，拿走了自己的一份苹果
     * 3.接着第二头熊重复这一过程
     * 4.即先均分n份，扔掉一个然后拿走一份
     * 5.以此类推直到最后一头熊都是这样(最后一头熊扔掉后可以拿走0个，也算是n份均分)
     * 6.问最初这堆苹果最少有多少个。
     * <p>
     * 给定一个整数n,表示熊的个数，返回最初的苹果数。保证有解。
     * <p>
     * 测试样例：
     * 2
     * 返回：3
     *
     * @apiNote 思路：
     * 1.
     */
    public static void main(String[] args) {
        for (int i = 2; i <= 4; i++) {
            System.out.println(code1(i));
            System.out.println(code2(i));
        }
    }
}
