package com.bins.bishi.autumn2020.yuewen;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/10/21 18:07
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 给定一个int 数字
     * 要求计算出int数字对应的二进制中1的个数
     * <p>
     * 示例1
     * 输入
     * 15
     * <p>
     * 输出
     * 4
     * <p>
     * 备注:
     * int数字大于0
     *
     * @apiNote 思路：
     * 1.用1和所有位进行&运算即可
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        System.out.println(count);
    }
}
