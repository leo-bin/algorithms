package com.bins.bishi.autumn2020.qianxin;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/1 15:28
 * @apiNote
 */
public class Main1 {


    /**
     * 题目描述
     * 1.2020年春节之际，新冠肺炎爆发，国内医疗资源大量紧缺
     * 2.小明作为一位采购员，被派到国外采购紧缺物资
     * 3.由于国内需要的物资种类很多，不同品牌种类的物资在疫情中的 使用价值 也不同
     * 4.在了解商品情况后，小明开始为采购哪些物资才最合适而烦恼。
     * 5.假如给定了采购预算 T , 每种物资的价格Pn和使用价值 Wn
     * 6.每种物资的可采购数量不限，你能帮他快速决定出应该采购的物资吗？
     * 7.要求采购物资的总价格不能超过采购预算
     * 8.在这个前提下给出的采购列表要使得这批物资的使用价值最大
     * <p>
     * 输入描述:
     * 每个测试输入包含一个测试用例
     * 第一行是总预算(不大于200000)
     * 第二行是物资种类总数 n (不大于20)
     * 后面有n行数据， 每一行代表一种物资的价格和使用价值，被空格分成两列， 每列数据值不大于15000
     * 例如 第3行数据中 第一列是物资1的价格P1, 第二列是物资2的使用价值 W1
     * 第4行数据中 第一列是物资2的价格 P2, 第二列是物资2的使用价值 W2。
     * 以此类推，第 n+2 行中第一列是物资 n 的价格 Pn ，第二列是 物资 n 的价格 Wn。
     * <p>
     * 输出描述:
     * 输出采购物资能达到的最高使用价值，格式是单独的一行 数值
     * <p>
     * 示例1：
     * 输入
     * 100
     * 5
     * 77 92
     * 22 22
     * 29 36
     * 50 46
     * 99 90
     * <p>
     * 输出
     * 114
     * <p>
     * 说明
     * 100预算、5种商品情况下，购买 1个商品一 和 1个商品二 可以达到最大使用价值114
     * <p>
     * 示例2：
     * 输入
     * 200
     * 8
     * 79 83
     * 58 81
     * 86 54
     * 110 1500
     * 62 52
     * 45 48
     * 68 62
     * 30 22
     * <p>
     * 输出
     * 253
     * <p>
     * 说明
     * 200预算、8种商品情况下，购买 1个商品二 、 1个商品四 和 一个商品八 可以达到最大使用价值253
     * <p>
     * 备注:
     * 注意：每种物资的可采购数量没有限制
     *
     * @apiNote 思路：
     * 1.就是一个完全背包问题。
     * 2.这里使用零钱兑换Ⅱ的一维dp来解决会比较好理解一点
     * 3.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }

        int[] dp = new int[money + 1];
        dp[0] = 0;
        for (int curMoney = 1; curMoney <= money; curMoney++) {
            for (int j = 1; j <= n; j++) {
                if (curMoney >= p[j - 1]) {
                    dp[curMoney] = Math.max(dp[curMoney], dp[curMoney - p[j - 1]] + w[j - 1]);
                }
            }
        }
        System.out.println(dp[money]);
    }
}
