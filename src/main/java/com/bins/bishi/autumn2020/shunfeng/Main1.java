package com.bins.bishi.autumn2020.shunfeng;

import java.util.*;

/**
 * @author leo-bin
 * @date 2020/8/20 17:54
 * @apiNote
 */
public class Main1 {

    /**
     * 题目描述：
     * 小A的购买了一批服务器，他准备将这些服务器租用出去。
     * 每一个服务器有一个固定的带宽，人们根据自己需要的带宽来租用这些服务器。
     * 一台服务器只能租给一个人。
     * 小A现在有n个空闲的服务器，第 i 个服务器拥有ai的带宽。
     * 有m个客户来租服务器，第 i 位客户需要带宽至少为bi的服务器，并且愿意花ci元作为预算。
     * 服务器带宽独立不可叠加，若不能成功租出则输出0
     * 小A可以选择拒绝一些人，现在，小A想知道自己的服务器最多能租多少钱？
     * <p>
     * 输入描述
     * 输入第一行包含两个数n,m
     * 接下来1行n个数，第i个数ai代表第 i 个服务器的带宽大小
     * 接下来m行，每行两个数bi,ci，代表客户需求的带宽大小和他的预算
     * n,m≤1000 , 1≤ai,bi,ci≤1000
     * <p>
     * 输出描述
     * 输出一个数，即小A最多能租多少元的服务器出去
     * <p>
     * 样例输入
     * 3 4
     * 1 2 3
     * 2 1
     * 3 2
     * 3 3
     * 1 1
     * <p>
     * 样例输出
     * 5
     * <p>
     * 样例解释
     * 1号服务器租给4号客户
     * 2号服务器租给1号客户
     * 3号服务器租给3号客户
     *
     * @apiNote 思路：
     * 1.根据给的价钱建立一个优先级队列
     * 2.然后直接租，有服务器就直接租给卖价最高的客户
     * 3.奇怪，只a了18%
     */

    public static class Client {
        private int b;
        private int c;

        public Client(int b, int c) {
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            int b = scanner.nextInt();
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        PriorityQueue<Client> maxHeap = new PriorityQueue<>((o1, o2) -> o2.c - o1.c);
        for (int i = 0; i < m; i++) {
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            maxHeap.add(new Client(b, c));
        }

        int maxSum = 0;
        for (int i = 0; i < m; i++) {
            Client client = maxHeap.poll();
            if (client != null) {
                Integer count = map.get(client.b);
                if (count != null && count > 0) {
                    maxSum += client.c;
                    map.put(client.b, count - 1);
                }
            }
        }
        System.out.println(maxSum);
    }
}
