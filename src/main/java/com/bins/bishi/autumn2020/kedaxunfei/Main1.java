package com.bins.bishi.autumn2020.kedaxunfei;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/7/31 13:50
 * @apiNote 提前批第一题：ac:0.4
 */
public class Main1 {

    /**
     * 题目描述
     * 有1,5,10,50,100元，分别有a,b,c,d,e张纸币。
     * 编程实现若要支付k元，则需要最少多少张纸币？
     * 其中a,b,c,d,e,k均为自然数。
     * <p>
     * 输入描述:
     * 输入为两行：
     * 第一行为5个数字，分别表示1元、5元、10元、50元、100元纸币的数量
     * 如： 5 2 2 3 5
     * 第二行为要支付的金额k
     * 如： 55
     * <p>
     * 输出描述:
     * 输出最少需要张数，如：2
     * 当无解时输出: -1
     * <p>
     * 示例1：
     * 输入
     * 5 2 2 3 5
     * 55
     * 输出
     * 2
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.dp[i]=min(dp[i],dp[i-coin]+1)
     * 3.dp公式成立的前提条件是：i>coin&&dp[i-coin]+1小于等于coin的数量
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, Integer> money = new TreeMap<>();
        money.put(1, scanner.nextInt());
        money.put(5, scanner.nextInt());
        money.put(10, scanner.nextInt());
        money.put(50, scanner.nextInt());
        money.put(100, scanner.nextInt());
        int target = scanner.nextInt();

        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (Map.Entry coin : money.entrySet()) {
                int price = (int) coin.getKey();
                int count = (int) coin.getValue();
                if (i >= price && (dp[i - price] + 1) < count) {
                    dp[i] = Math.min(dp[i], dp[i - price] + 1);
                }
            }
        }
        System.out.println(dp[target] == target + 1 ? -1 : dp[target]);
    }
}
