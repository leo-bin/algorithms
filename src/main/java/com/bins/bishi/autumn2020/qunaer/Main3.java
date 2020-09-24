package com.bins.bishi.autumn2020.qunaer;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/23 18:05
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 德州扑克的花型由N张扑克牌组成 0 < N < 8，可以组成的牌型按照价值从高到低来区分分别为：
     * 1.皇家同花顺：最高为Ace（一点）的同花顺。
     * 如A K Q J 10 的同花顺
     * 2.同花顺：同一花色，五张顺序的牌。
     * 如：K Q J 10 9 的同花顺
     * 3.四条：有四张同一点数的牌。
     * 如：4 4 4 4 9
     * 4.葫芦：三张同一点数的牌，加一对其他点数的牌。
     * 如：3 3 3 10 10
     * 5.同花：五张同一花色的牌。
     * 如：J 10 8 7 5 的全是红桃的牌
     * 6.顺子：五张顺连的牌。
     * 如：5 4 3 2 A 的非同花牌（此牌型为最小的顺子）
     * 7.三条：仅有三张同一点数的牌，其余两张点数不同。
     * 如: 9 9 9 5 3
     * 8：两对：两张相同点数的牌，加另外两张相同点数的牌。
     * 如：K K 5 5 2
     * 9.一对：仅有两张相同点数的牌。
     * 如：10 10 9 4 2
     * 10.高牌：不符合上面任何一种牌型的牌型，由单牌且不连续不同花的组成，以点数决定大小。
     * 如：A 10 9 5 3 的非同花的牌
     * 这十种牌型分别输出 HuangJiaTongHuaShun、TongHuaShun、SiTiao、HuLu、TongHua、ShunZi、SanTiao、LiangDui、YiDui、GaoPai
     * 扑克牌有4种花色，分别为 （S表示黑桃，H表示红心，C表示草花，D表示方片）
     * 本题的输入为任意 小于 8 的 N张牌
     * 得到的结果为这些牌中排序最靠前的类型
     * <p>
     * 输入描述
     * 2（牌数为2）
     * SA HA (两张牌为黑桃A 红心A)
     * <p>
     * 输出描述
     * YiDui (结果为一对)
     * <p>
     * 样例输入
     * 5
     * SA SK SQ SJ S10
     * 样例输出
     * HuangJiaTongHuaShun
     *
     * @apiNote 思路：
     * 1.骗了18%
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

    }
}
