package com.bins.bishi.autumn2020.shunfeng;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/20 17:54
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 克里森是一名赏金猎人，他平时需要完成一些任务赚钱。
     * 最近他收到了一批任务，但是受到时间的限制，他只能完成其中一部分。
     * 具体来说就是有n个任务，每个任务用l, r, w来表示任务开始的时间l，结束的时间r和完成任务获得的金钱
     * 克里森是个贪心的人，他想知道自己在任务不冲突的情况下最多获得多少金钱。
     * <p>
     * 输入描述
     * 第一行一个数n表示任务的个数。(1≤n≤1e3)
     * 接下来n行每行三个整数l, r, w表示第i个任务的开始时间，结束时间，以及收益。(1≤l≤r≤1e6,1≤w≤1e9)
     * <p>
     * 输出描述
     * 输出一个值表示克里森最多获得的金钱数量。
     * <p>
     * 样例输入
     * 3
     * 1 3 5
     * 2 7 3
     * 5 10 1
     * <p>
     * 样例输出
     * 6
     *
     * @apiNote 思路：
     * 1.依旧使用优先级队列维护一个最大价值队列
     * 2.然后根据每一个任务的开始时间和结束时间进行判断是否能做该任务
     * 3.只能过18%
     */
    public static class Node {
        private int l;
        private int r;
        private int w;

        public Node(int l, int r, int w) {
            this.l = l;
            this.r = r;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> o2.w - o1.w);
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int w = scanner.nextInt();
            maxHeap.add(new Node(l, r, w));
        }

        int maxSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            Node node = maxHeap.poll();
            if (node != null) {
                if (node.l > start) {
                    maxSum += node.w;
                    start = node.r + 1;
                }
            }
        }
        System.out.println(maxSum);
    }
}
