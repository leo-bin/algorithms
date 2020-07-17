package com.bins.bishi.spring2020.jingdong;

/**
 * @author leo-bin
 * @date 2020/4/17 17:32
 * @apiNote 公式：
 * 1.等比数列求和公式
 * S(n)=a0*(1-q^n)/(1-q)
 * <p>
 * 2.等差数列求和公式
 * S(n)=a0*n+n*(n-1)*d/2或者：S(n)=(a0+a(n)*n/2
 * 3.Java中对任意对数的求解
 * logxN(以x为底，N的对数)=Math.log((double)N)/Math.log((double)x)
 */
public class Balls {

    /**
     * 题目描述：
     * 1.小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层
     * 2.假设小东站的楼层距离地面N米
     * 3.球从他手里自由落下，每次落地后反跳回上次下落高度的一半
     * 4.并以此类推直到全部落到地面不跳
     * 5.求4个小球一共经过了多少米？(数字都为整数)
     * 6.给定四个整数A,B,C,D，请返回所求结果
     * <p>
     * 测试样例：
     * 100,90,80,70
     * 返回：
     * 1020
     *
     * @apiNote 思路：
     * 1.使用等比数列的求和公式暴力求解
     */
    public static int calcDistance(int A, int B, int C, int D) {
        if (A < 0 || B < 0 || C < 0 || D < 0) {
            return 0;
        }
        return (int) (check(A) + check(B) + check(C) + check(D));
    }


    /**
     * 计算前n项
     */
    public static double check(int N) {
        //n<=log2N
        double n = (Math.log(N) / Math.log(2)) + Integer.MAX_VALUE;
        return (3 * N * (1 - Math.pow(1.0 / 2, n)));
    }


    public static void main(String[] args) {
        int A = 100;
        int B = 90;
        int C = 80;
        int D = 70;
        System.out.println(calcDistance(A, B, C, D));
    }
}
