package com.bins.bishi.autumn2020.netease.bishi2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/24 10:21
 * @apiNote
 */
public class Main1 {


    /**
     * 题目描述：
     * 1.小易有一个古老的游戏机，上面有着经典的游戏俄罗斯方块
     * 2.因为它比较古老，所以规则和一般的俄罗斯方块不同。
     * 3.荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下
     * 4.在同一列中，后落下的方块会叠在先前的方块之上
     * 5.当一整行方块都被占满时，这一行会被消去，并得到1分。
     * 6.有一天，小易又开了一局游戏
     * 7.当玩到第 m 个方块落下时他觉得太无聊就关掉了
     * 8.小易希望你告诉他这局游戏他获得的分数。
     * <p>
     * 输入描述:
     * 第一行两个数 n, m
     * 第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
     * 其中 1 <= n, m <= 1000, 1 <= ci <= n
     * <p>
     * 输出描述:
     * 小易这局游戏获得的分数
     * <p>
     * 输入例子1:
     * 3 9
     * 1 1 2 2 2 3 1 2 3
     * <p>
     * 输出例子1:
     * 2
     *
     * @apiNote 思路：
     * 1.送分题不解释了
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>(16);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int cur;
        for (int i = 0; i < m; i++) {
            cur = scanner.nextInt();
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }
        int result = Integer.MAX_VALUE;
        for (Map.Entry entry : map.entrySet()) {
            result = Math.min(result, (Integer) entry.getValue());
        }
        result = result == 1 ? 0 : result;
        System.out.println(result);
    }
}
