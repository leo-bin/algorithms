package com.bins.bishi.autumn2020.dianhun;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/9/17 16:31
 * @apiNote 电魂笔试
 */
public class Main1 {

    /**
     * 题目描述：
     * 1.连连看游戏中，一张m * n的格子地图上
     * 2.现在共有x个方块，每个方块可能存在的类型有4种，分别为typeA，typeB，typeC，typeD
     * 3.使用Java代码实现任意两个方块的连通性检查，并符合下列要求:
     * a.自己设计本题中涉及的数据结构
     * b.检查函数传入的两个方块是否可消除(方块类型不同则不可消除),可消除返回true,不可消除返回false
     * c.如果函数传入的两个方块不可消除则检查地图上是否还存在可消除的格子，如果不存在，则打印出无法消除的方块的位置和类型。
     *
     * @apiNote 思路：
     * 1.回溯
     * 2.m*n矩阵：0代表无方块，1代表typeA，2代表typeB，3代表typeC，4代表typeD
     */
    public static boolean linkGame(int[][] map, int[] a, int[] b) {
        boolean[][] marked = new boolean[map.length][map[0].length];
        return find(map, a[0], a[1], b, marked);
    }

    /**
     * 回溯
     */
    public static boolean find(int[][] map, int i, int j, int[] target, boolean[][] marked) {
        //递归结束条件
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || marked[i][j]) {
            return false;
        }
        if (map[i][j] != 0 && map[i][j] != map[target[0]][target[1]]) {
            return false;
        }
        if (i == target[0] && j == target[1] && map[i][j] == map[target[0]][target[1]]) {
            return true;
        }
        marked[i][j] = true;
        if (find(map, i + 1, j, target, marked) ||
                find(map, i - 1, j, target, marked) ||
                find(map, i, j + 1, target, marked) ||
                find(map, i, j - 1, target, marked)) {
            return true;
        }
        marked[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int[] a = new int[2];
        int[] b = new int[2];
        a[0] = scanner.nextInt();
        a[1] = scanner.nextInt();
        b[0] = scanner.nextInt();
        b[1] = scanner.nextInt();
        if (linkGame(map, a, b)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
