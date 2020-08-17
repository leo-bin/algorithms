package com.bins.question.backtrace;

import java.util.ArrayList;

/**
 * @author leo-bin
 * @date 2020/8/17 15:02
 * @apiNote 节点间通路
 * 来源：leetcode-面试题 04.01
 * 链接：https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class FindWhetherExistsPath {

    /**
     * 题目描述：
     * 1.节点间通路
     * 2.给定有向图，设计一个算法
     * 3.找出两个节点之间是否存在一条路径
     * <p>
     * 示例1:
     * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
     * 输出：true
     * <p>
     * 示例2:
     * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]],
     * start = 0, target = 4
     * 输出 true
     * <p>
     * 提示：
     * 节点数量n在[0, 1e^5]范围内
     * 节点编号大于等于 0 小于 n
     * 图中可能存在自环和平行边
     *
     * @apiNote 思路：
     * 1.使用邻接表+dfs解决
     */
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        ArrayList<Integer>[] graphList = new ArrayList[n];
        //先建立邻接表:0->1->2  1->2->2
        for (int i = 0; i < n; i++) {
            graphList[i] = new ArrayList<>();
        }
        for (int[] edge : graph) {
            graphList[edge[0]].add(edge[1]);
        }
        boolean[] marked = new boolean[n];
        //使用dfs搜索路径
        return dfs(graphList, start, target, marked);
    }

    /**
     * 对邻接表进行dfs搜索
     */
    public static boolean dfs(ArrayList<Integer>[] graphList, int start, int target, boolean[] marked) {
        //递归结束条件
        if (start == target) {
            return true;
        } else {
            marked[start] = true;
            for (int next : graphList[start]) {
                //换个起点重新开始找
                if (!marked[next] && dfs(graphList, next, target, marked)) {
                    return true;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        int start = 0;
        int target = 2;
        System.out.println(findWhetherExistsPath(n, graph, start, target));
    }
}
