package com.bins.bishi.autumn2020.alibaba.event727;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/4 11:43
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.有个藏宝架有n层，每层的宝物数量不一
     * 2.每个宝物都有其价值，现在要求拿出m个宝物，并且需要遵守规则：
     * 3.每次只能拿选定层的两端的宝物
     * 4.要拿出的m个宝物的总价值是各种方案里最大的
     * 输入：
     * n m
     * 下面每行代表每层，且第一个数是这层宝物的数量k，后面的则是k个宝物的价值
     * 4 1 2 4 5
     * 5 1 2 4 5 5
     * 样例：
     * 2 3
     * 2 3 2
     * 4 1 4 1 5
     * 输出：5+3+2=10
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code(int m, List<List<Integer>> lists) {

        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                list.add(scanner.nextInt());
            }
            lists.add(list);
        }
        System.out.println(code(m, lists));
    }
}
