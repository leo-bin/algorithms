package com.bins.question.backtrace;

/**
 * @author leo-bin
 * @date 2020/4/20 12:08
 * @apiNote 岛屿的数量
 */
public class NumOfIslands {


    /**
     * 题目描述：
     * 1.给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量
     * 2.岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成
     * 3.此外，你可以假设该网格的四条边均被水包围
     * <p>
     * 示例 1:
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     * 解释: 每座岛屿只能由水平或竖直方向上相邻的陆地连接而成。
     *
     * @apiNote 思路：
     * 1.这道题本质上是一个深度优先搜索的问题
     * 2.我们从第一个位置开始，只需要判断下它的上下左右四个位置是否是1，如果是1，标记为2
     * 3.然后递归的从这四个位置依次判断就行
     * 4.递归结束条件需要判断下是否越界，是否是1
     * 5.时间复杂度：O(m*n*)
     * 6.空间复杂度：O(m*n)
     */
    public static int numOfIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }



    /**
     * 感染函数
     */
    public static void infect(char[][] grid, int i, int j) {
        //判断是否越界或者是不是满足题目的条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        //感染当前的位置
        grid[i][j] = '2';
        //往上感染
        infect(grid, i - 1, j);
        //往下感染
        infect(grid, i + 1, j);
        //往左感染
        infect(grid, i, j - 1);
        //往右感染
        infect(grid, i, j + 1);
    }


    public static void main(String[] args) {

    }
}
