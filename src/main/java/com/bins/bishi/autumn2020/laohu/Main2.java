package com.bins.bishi.autumn2020.laohu;


/**
 * @author leo-bin
 * @date 2020/8/16 16:24
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.给定一个包含非负整数的 m x n 网格
     * 2.请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 3.说明：每次只能向下或者向右移动一步
     * <p>
     * 示例1
     * 输入
     * [   [1,3,1],   [1,5,1],   [4,2,1] ]
     * <p>
     * 输出
     * 7
     *
     * @apiNote 思路：
     * 1.dp思想
     * 2.
     */
    public static int code(int[][] arr) {
        //特判
        if (arr.length <= 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][arr[0].length];
        //初始化dp
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int j = 1; j < arr[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(code(arr));
    }
}
