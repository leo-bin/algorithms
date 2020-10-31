package com.bins.question.backtrace;

/**
 * @author leo-bin
 * @date 2020/10/30 16:45
 * @apiNote 岛屿的周长
 * 来源：leetcode-463
 * 链接：https://leetcode-cn.com/problems/island-perimeter/
 */
public class IslandPerimeter {

    /**
     * 题目描述：
     * 1.给定一个包含0和1的二维网格地图，其中1表示陆地0表示水域
     * 2.网格中的格子水平和垂直方向相连（对角线方向不相连）
     * 3.整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）
     * 4.岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）
     * 5.格子是边长为1的正方形。网格为长方形，且宽度和高度均不超过 100
     * 6.计算这个岛屿的周长
     * <p>
     * 示例:
     * 输入:
     * [[0,1,0,0],
     * [1,1,1,0],
     * [0,1,0,0],
     * [1,1,0,0]]
     * <p>
     * 输出: 16
     * 解释: 它的周长是下面图片中的16个黄色的边：
     *
     * @apiNote 思路：
     * 1.这个题目要想明白其实很简单，我们从一个格子开始考虑
     * 2.通过观察可以看出来，一个格子的周长最多是4，也就是四个边，这种情况下一个格子就是一个岛屿
     * 3.具体如何计算一个格子的周长需要看它四个方向（上下左右）的情况
     * 4.如果格子的一边是水或者越界了，那么周长都要+1
     * 5.如果格子的一边是格子，那么这一边就不算，继续下一个格子的统计，这一点通过递归dfs就可
     */
    private static int length = 0;

    public static int islandPerimeter(int[][] grid) {
        //特判
        if (grid.length <= 0) {
            return 0;
        }
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, marked);
                    return length;
                }
            }
        }
        return length;
    }

    /**
     * dfs
     */
    public static void dfs(int[][] grid, int i, int j, boolean[][] marked) {
        //递归结束条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            length++;
            return;
        }
        if (marked[i][j]) {
            return;
        }
        marked[i][j] = true;
        //统计四个方向的情况
        dfs(grid, i + 1, j, marked);
        dfs(grid, i - 1, j, marked);
        dfs(grid, i, j + 1, marked);
        dfs(grid, i, j - 1, marked);
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}};
        System.out.println(islandPerimeter(grid));
    }
}
