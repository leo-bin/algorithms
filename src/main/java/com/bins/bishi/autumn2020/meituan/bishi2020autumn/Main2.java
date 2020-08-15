package com.bins.bishi.autumn2020.meituan.bishi2020autumn;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/15 15:51
 * @apiNote
 */
public class Main2 {

    /**
     * 题目描述：
     * 小团是一个旅游爱好者，快要过春节了，他想统计一下，在过去的一年中他进行过几次旅行
     * 于是他打开了美团app的订单记录，记录显示了他的购买车票的记录
     * 记录是按时间顺序给出的，已知一次旅行的线路一定是一个闭环，即起点和终点是同一个地点
     * 因此当每找到一段闭合的行程，即认为完成了一次旅行
     * 数据保证不会出现不在闭环路径中的数据。
     * 请你在小团的购票记录中统计出他全年共进行了多少次旅行？
     * <p>
     * 输入描述
     * 输入第一行包含一个正整数n，表示小团的购票记录数量。(1<=n<=10000)
     * 接下来有n行，每行是两个长度不超过10的仅由小写字母组成的字符串S_a S_b，表示购买了一张从S_a到S_b的车票。
     * <p>
     * 输出描述
     * 输出仅包含一个整数，表示小团的旅行次数。
     * <p>
     * 样例输入
     * 6
     * beijing nanjing
     * nanjing guangzhou
     * guangzhou shanghai
     * shanghai beijing
     * fuzhou beijing
     * beijing fuzhou
     * <p>
     * 样例输出
     * 2
     *
     * @apiNote 思路：
     * 1.
     */


    /**
     * 内部节点
     */
    private static class Node {
        private String start;
        private String end;
        private Node next;

        public Node(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }


    /**
     * dfs搜索
     */
    public static boolean dfs(Node start) {

        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> trip = new ArrayList<>();
        Node lastNode = null;
        for (int i = 0; i < n; i++) {
            String start = scanner.next();
            String end = scanner.next();
            Node node = new Node(start, end);
            if (lastNode != null && start.equals(lastNode.end)) {
                lastNode.next = node;
            } else {

            }
            lastNode = node;
        }

        int count = 0;
        for (int i = 0; i < trip.size(); i++) {
            if (dfs(trip.get(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
