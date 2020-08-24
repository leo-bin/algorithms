package com.bins.bishi.autumn2020.tencent;

import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/23 19:46
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述
     * 小Q给你一个单链表
     * 小Q希望能删除链表中的第k个节点，并返回删除之后的单链表
     * <p>
     * 输入描述:
     * 输出的第一行有两个正整数n, k, n表示链表的长度,k表示要删除的节点。
     * 第二行为原始单链表中依次每个节点的值val。
     * 1 <= k <= n <= 1000000,  -1000000 <= val <= 1000000
     * <p>
     * 输出描述:
     * 返回链表的头指针, 并依次打印删除之后的链表中的值
     * <p>
     * 示例1
     * 输入
     * 5 3
     * 1 2 3 4 5
     * <p>
     * 输出
     * 1 2 4 5
     *
     * @apiNote 思路：
     * 1.这题的时间限制就离谱
     * 2.按道理来说下面这种写法已经很快了，但是依旧过不了
     * 3.需要在输入的时候就进行判断
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        //特判
        if (k < 0 || k - 1 >= n) {
            print(nums, -1);
        } else {
            print(nums, k - 1);
        }
    }

    public static void print(int[] nums, int index) {
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            System.out.print(nums[i] + " ");
        }
    }
}
