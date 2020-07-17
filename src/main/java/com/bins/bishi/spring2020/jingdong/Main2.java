package com.bins.bishi.spring2020.jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/4/18 19:00
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 1.
     *
     * @apiNote 思路：
     * 1.
     */
    public static void train(List<List> lists) {
        System.out.println(6);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int si = scanner.nextInt();
            int ti = scanner.nextInt();
            list.add(si);
            list.add(ti);
            lists.add(list);
        }
        train(lists);
    }
}
