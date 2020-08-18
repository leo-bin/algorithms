package com.bins.bishi.autumn2020.yongyou;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/8/18 15:36
 * @apiNote
 */
public class Main3 {

    /**
     * 题目描述：
     * 有 n 个城市通过 m 个航班连接。每个航班都从城市u开始，以价格w抵达v
     * 现在给定所有的城市和航班，以及出发城市src
     * 你的任务是找到从 scr城市出发到其他所有城市最便宜的机票价格列表
     * 假设两个城市之间机票价格不会超过Integer.MAX_VALUE，如果无法从scr到达某个城市，则它们的价格-1表示
     * <p>
     * 示例 1
     * 输入: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]], src = 0
     * 输出: [0, 100, 200]
     * 解释: 0号城市到达1号城市花费为100，到达2号城市为先到1号再从1号城市到2号城市花费100+100=200。
     * <p>
     * 输入: n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]], src = 1
     * 输出: [-1, 0, 100]
     * 解释: 1号城市无法到达0号城市，1号城市到达2号城市的最少花费为100
     * <p>
     * 示例 2
     * 输入: n = 5,edges = [[0,1,10],[0,3,40],[1,2,20],[1,3,100],[1,4,30],[2,3,50],[3,4,60]],src = 1
     * 输出: [-1, 0, 20, 70, 30]
     * 解释: 1号城市无法到达0号城市，输出-1。
     * <p>
     * 输入：n = 5,edges = [[0,1,10],[0,3,40],[1,2,20],[1,3,100],[1,4,30],[2,3,50],[3,4,60]],src = 0
     * 输出：[0, 10, 30, 40, 40]
     * 解释：0号城市可以到达所有的城市。
     * <p>
     * 输入：n = 5,edges = [[0,1,10],[0,3,40],[1,2,20],[1,3,100],[1,4,30],[2,3,50],[3,4,60]],src = 3
     * 输出：[-1, -1, -1, 0, 60]
     * 解释：3号城市只能到达4号城市
     * <p>
     * java示例参考
     * 评分标准（10分制）
     * 代码中 ===== x分 ====== 表示写到当前为止的代码得分。
     * 总分10分包含 逻辑代码（9分），注释，命令规范，代码对齐等（1分）。
     * 如果明确在代码中说明使用“Dijkstra算法”等根据代码情况酌情给3-5分。
     * 如果使用暴力破解方法则在逻辑且代码正确情况下酌情给6-7分。
     *
     * @apiNote 思路：
     * 1.dfs
     */

    private static int[] result;

    public static int[] findAllCheapestPrice(int n, int[][] flights, int src) {
        result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        dfs(flights, src, 0, 0);
        return result;
    }

    /**
     * dfs
     */
    public static void dfs(int[][] flights, int from, int target, int price) {
        //递归结束条件
        if (from == target) {
            result[target] = Math.min(result[target], price);
        }

        int[] f = flights[target];
        dfs(flights, target, f[1], price);
    }


    public static void main(String[] args) {

    }
}
