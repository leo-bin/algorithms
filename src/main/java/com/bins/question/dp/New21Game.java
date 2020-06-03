package com.bins.question.dp;

/**
 * @author leo-bin
 * @date 2020/6/3 22:05
 * @apiNote 新21点游戏
 * 来源：leetcode-837
 * 链接：https://leetcode-cn.com/problems/new-21-game/
 */
public class New21Game {


    /**
     * 题目描述：
     * 1.爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
     * 2.爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字
     * 3.抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数
     * 4.每次抽取都是独立的，其结果具有相同的概率。
     * 5.当爱丽丝获得不少于 K 分时，她就停止抽取数字
     * 6.爱丽丝的分数不超过 N 的概率是多少？
     * <p>
     * 示例 1：
     * 输入：N = 10, K = 1, W = 10
     * 输出：1.00000
     * 说明：爱丽丝得到一张卡，然后停止。
     * <p>
     * 示例 2：
     * 输入：N = 6, K = 1, W = 10
     * 输出：0.60000
     * 说明：爱丽丝得到一张卡，然后停止。
     * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
     * <p>
     * 示例 3：
     * 输入：N = 21, K = 17, W = 10
     * 输出：0.73278
     *
     * @apiNote 思路：
     * 1.dp
     * 2.一开始题目都没看懂，之后看答案，答案也没看懂。。。太菜了。
     * 3.明天再看吧，写了一天的vue了，有点累。。。
     */
    public static double new21Game(int N, int K, int W) {
        // 先判断 K - 1 + W 是否在 N 的里面，如果在的话，说明肯定能赢得游戏，返回 1.0，也就是 100%
        if (N - K + 1 >= W) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        // 将能赢得游戏的点数的概率设置为 1
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        // 计算K + W 这几个点数的概率和
        double sumProb = N - K + 1;
        // 从 K - 1 开始计算，
        for (int i = K - 1; i >= 0; i--) {
            // 点数为 i 的赢得游戏的概率为 i + 1 ~ i + W 的概率和除以 W
            dp[i] = sumProb / W;
            sumProb = sumProb - dp[i + W] + dp[i];
        }
        return dp[0];
    }

    public static void main(String[] args) {

    }
}
