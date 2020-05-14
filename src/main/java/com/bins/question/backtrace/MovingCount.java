package com.bins.question.backtrace;


/**
 * @author leo-bin
 * @date 2020/4/21 16:38
 * @apiNote 机器人的运动范围
 */
public class MovingCount {


    /**
     * 题目描述：
     * 1.地上有一个m行和n列的方格
     * 2.一个机器人从坐标0,0的格子开始移动
     * 3.每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子
     * 4.例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18
     * 5.但是，它不能进入方格（35,38），因为3+5+3+8 = 19
     * 6.请问该机器人能够达到多少个格子？
     *
     * @apiNote 思路：
     * 1.回溯
     * 2.
     */
    public static int movingCount(int threshold, int rows, int cols) {
        //鲁棒
        if (rows <= 0 || cols <= 0 || threshold <= 0) {
            return 0;
        }
        //构建一个标记数组，代表机器人走过的路径
        boolean[][] flag = new boolean[rows][cols];
        return counter(threshold, rows, cols, 0, 0, flag);
    }


    /**
     * 回溯
     */
    public static int counter(int k, int rows, int cols, int i, int j, boolean[][] flag) {
        //递归结束条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] || !check(i, j, k)) {
            return 0;
        }
        //标记
        flag[i][j] = true;
        //上下左右分别回溯
        return counter(k, rows, cols, i - 1, j, flag)
                + counter(k, rows, cols, i + 1, j, flag)
                + counter(k, rows, cols, i, j - 1, flag)
                + counter(k, rows, cols, i, j + 1, flag) + 1;
    }


    /**
     * 校验，横坐标，纵坐标，各位之和是否超过阈值
     */
    public static boolean check(int x, int y, int k) {
        int sum = 0;
        String strX = String.valueOf(x);
        String strY = String.valueOf(y);
        for (int i = 0; i < strX.length(); i++) {
            sum += strX.charAt(i) - '0';
        }
        for (int j = 0; j < strY.length(); j++) {
            sum += strY.charAt(j) - '0';
        }
        return sum <= k;
    }


    public static void main(String[] args) {
        int k = 15;
        int rows = 20;
        int cols = 20;
        System.out.println(movingCount(k, rows, cols));
    }
}
