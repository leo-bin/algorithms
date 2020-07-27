package com.bins.bishi.autumn2020.netease.bishi2018;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author leo-bin
 * @date 2020/7/27 11:45
 * @apiNote
 */
public class Main1 {

    public static class Node {
        private int d;
        private int p;

        public Node(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }

    /**
     * 题目描述：
     * 1.为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬
     * 2.牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作
     * 3.在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作
     * 4.牛牛依然使用自己的标准来帮助小伙伴们
     * 5.牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
     * <p>
     * 输入描述:
     * 每个输入包含一个测试用例。
     * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
     * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
     * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
     * 保证不存在两项工作的报酬相同。
     * <p>
     * 输出描述:
     * 对于每个小伙伴，在单独的一行输出一个整数表示他能得到的最高报酬。如果他找不到工作，则输出0。一个工作可以被多个人选择。
     * <p>
     * 输入例子1:
     * 3 3
     * 1 100
     * 10 1000
     * 1000000000 1001
     * 9 10 1000000000
     * <p>
     * 输出例子1:
     * 100
     * 1000
     * 1001
     *
     * @apiNote 思路：
     * 1.二分
     * 2.
     */
    public static int code(ArrayList<Node> list, int a) {
        int max = 0;
        int left = 0, right = list.size()-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Node node = list.get(mid);
            if (a >= node.d) {
                max = Math.max(max, node.p);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int p = scanner.nextInt();
            list.add(new Node(d, p));
        }
        list.sort((o1, o2) -> o1.d - o2.d);
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            System.out.println(code(list, a));
        }
    }
}
