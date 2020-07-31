package com.bins.bishi.autumn2020.kedaxunfei;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/31 13:50
 * @apiNote 提前批第三题：ac:0.67
 */
public class Main3 {

    /**
     * 题目描述
     * 使用对角线相连的两个点表示一个矩形
     * 如矩形 (0,0),(2,1) 表示 (0,0),(2,0),(2,1),(0,1)所围成的矩形区域。
     * 编程实现判断输入的两个矩形是否相交。
     * <p>
     * 输入描述:
     * 输入一行8个整数，如 ： 0 0 4 2 0 1 5 3
     * 前面4个整数表示第一个矩形的对点坐标，后面4个数字表示第二个矩形的对点坐标
     * <p>
     * 输出描述:
     * 相交返回1，不相交输出0
     * <p>
     * 示例:
     * 输入
     * 0 0 4 3 0 1 5 4
     * <p>
     * 输出
     * 1
     *
     * @apiNote 思路：
     * 1.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rec1 = new int[4];
        for (int i = 0; i < 4; i++) {
            rec1[i] = scanner.nextInt();
        }

        int[] rec2 = new int[4];
        for (int i = 0; i < 4; i++) {
            rec2[i] = scanner.nextInt();
        }

        int result = !(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec2[2] <= rec1[0] || rec2[3] <= rec1[1]) ? 1 : 0;
        System.out.println(result);
    }
}
