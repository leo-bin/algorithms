package com.bins.bishi.autumn2020.nowcoder;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/17 19:39
 * @apiNote code2
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.最近天气太热了，牛牛每天都要吃雪糕
     * 2.雪糕有一盒一份、一盒两份、一盒三份这三种包装，牛牛一天可以吃多盒雪糕，但是只能吃六份
     * 3.吃多了就会肚子疼，吃少了就会中暑
     * 4.而且贪吃的牛牛一旦打开一盒雪糕，就一定会把它吃完
     * 5.请问牛牛能健康地度过这段高温期么？
     * <p>
     * 输入描述:
     * 1.每个输入包含多个测试用例。
     * 2.输入的第一行包括一个正整数，表示数据组数T(1<=T<=100)。
     * 3.接下来N行，每行包含四个正整数，表示高温期持续的天数N(1<=N<=10000)
     * 4.一盒一份包装的雪糕数量A(1<=A<=100000)
     * 5.一盒两份包装的雪糕数量B(1<=B<=100000)
     * 6.一三份包装的雪糕数量C(1<=A<=100000)
     * <p>
     * 输出描述:
     * 对于每个用例，在单独的一行中输出结果。如果牛牛可以健康地度过高温期则输出"Yes"，否则输出"No"。
     * <p>
     * 输入:
     * 4
     * 1 1 1 1
     * 2 0 0 4
     * 3 0 2 5
     * 4 24 0 0
     * 输出:
     * Yes
     * Yes
     * No
     * Yes
     *
     * @apiNote 思路：
     * 1.
     */
    public static void code(int days, int oneCount, int twoCount, int threeCount) {

        String result = "Yes";
        System.out.println(result);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int days = scanner.nextInt();
            int oneCount = scanner.nextInt();
            int twoCount = scanner.nextInt();
            int threeCount = scanner.nextInt();
            code(days, oneCount, twoCount, threeCount);
        }
    }
}
