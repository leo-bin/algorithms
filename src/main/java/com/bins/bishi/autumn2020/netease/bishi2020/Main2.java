package com.bins.bishi.autumn2020.netease.bishi2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/8 12:38
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述
     * 给定长度为 m 的序列 T ,求一个长度为 n 且字典序最小的排列
     * 并且要求序列 T 为所求排列的子序列
     * 题目保证这样的排列一定存在
     * S 是 T 的子序列,当且仅当 S 是 T 通过删除任意数量元素所得到的
     * 字典序是单词在字典中的排列顺序，先比较第一个字母，然后比较第二个字母，依次类推
     * <p>
     * 输入描述:
     * 第一行输入两个正整数 n 和 m.
     * 第二行输入 m 个数,表示输入序列 T
     * 10<= m <= n <= 100000
     * <p>
     * 输出描述:
     * 输出一行表示答案(注意处理行末空格)
     * <p>
     * 示例1
     * 输入
     * 5 3
     * 2 1 5
     * <p>
     * 输出
     * 2 1 3 4 5
     * <p>
     * 示例2
     * 输入
     * 5 2
     * 4 2
     * <p>
     * 输出
     * 1 3 4 2 5
     *
     * @apiNote 思路：
     * 1.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] T = new int[m];
        for (int i = 0; i < m; i++) {
            T[i] = scanner.nextInt();
        }

        //构造所需要的元素数组
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        //去重
        for (Integer e : T) {
            list.remove(e);
        }

        //寻找
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for (int j = 0; j < list.size(); j++) {
            Integer e = list.get(j);
            for (int i = index; i < T.length; i++) {
                if (e <= T[i]) {
                    result.add(e);
                    index = i;
                    if (i != T.length - 1 || j != list.size() - 1) {
                        break;
                    }
                }
                result.add(T[i]);
            }
        }

        if (result.size() != n) {
            for (Integer e : list) {
                if (!result.contains(e)) {
                    result.add(e);
                }
            }
        }

        //打印
        for (int e : result) {
            System.out.print(e + " ");
        }
    }
}
