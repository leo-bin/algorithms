package com.bins.bishi.jingdong;

/**
 * @author leo-bin
 * @date 2020/4/17 17:04
 * @apiNote 奖金问题
 */
public class Bonus {


    /**
     * 题目描述：
     * 1.小东所在公司要发年终奖，而小东恰好获得了最高福利
     * 2.他要在公司年会上参与一个抽奖游戏，游戏在一个6*6的棋盘上进行
     * 3.上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物
     * 4.他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止
     * 5.一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物
     * 6.给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值
     * 7.左上角为[0,0],请返回能获得的最大价值，保证每个礼物价值大于100小于1000
     *
     * @apiNote 思路：
     * 1.最优解一般都是dp问题
     * 2.dp[0][0-len]=0,dp[0-len][0]=0
     * 3.状态方程，dp[i][j]=max(dp[i-1][j],dp[i][j-1])+board[i-1][j-1]
     * 4.时间复杂度：O(n*n)
     * 5.空间复杂度：O(n*n)
     */
    public static int getMostBonus(int[][] board) {
        int lenX = board.length;
        int lenY = board[0].length;
        if (lenX == 1 && lenY == 1) {
            return board[0][0];
        }
        //1.定义dp数组
        int[][] dp = new int[lenX + 1][lenY + 1];
        //2.初始化dp数组
        for (int i = 0; i <= lenX; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= lenY; j++) {
            dp[0][j] = 0;
        }
        //3.根据状态方程打表
        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i - 1][j - 1];
            }
        }
        return dp[lenX][lenY];
    }

    public static void main(String[] args) {

    }
}
