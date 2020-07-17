package com.bins.bishi.autumn2020.nowcoder;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/7/17 19:39
 * @apiNote
 */
public class Main3 {

    public static class Node {
        private int id;
        private int targetId;
        private int distance;

        public Node(int id, int targetId, int distance) {
            this.id = id;
            this.targetId = targetId;
            this.distance = distance;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getTargetId() {
            return targetId;
        }

        public void setTargetId(int targetId) {
            this.targetId = targetId;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
    private static int minDistance;

    /**
     * 题目描述：
     * 1.牛牛的快递到了，他迫不及待地想去取快递
     * 2.但是天气太热了，以至于牛牛不想在烈日下多走一步
     * 3.他找来了你，请你帮他规划一下，他最少要走多少距离才能取回快递
     * <p>
     * 输入描述:
     * 1.每个输入包含一个测试用例
     * 2.输入的第一行包括四个正整数
     * 3.表示位置个数N(2<=N<=10000)，道路条数M(1<=M<=100000)，起点位置编号S(1<=S<=N)和快递位置编号T(1<=T<=N)
     * 4.位置编号从1到N，道路是单向的
     * 5.数据保证S≠T，保证至少存在一个方案可以从起点位置出发到达快递位置再返回起点位置。
     * 6.接下来M行，每行包含三个正整数
     * 7.表示当前道路的起始位置的编号U(1<=U<=N)，当前道路通往的位置的编号V(1<=V<=N)和当前道路的距离D(1<=D<=1000)
     * <p>
     * 输出描述:
     * 对于每个用例，在单独的一行中输出从起点出发抵达快递位置再返回起点的最短距离。
     * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * 3 3 1 3
     * 1 2 3
     * 2 3 3
     * 3 1 1
     * 输出
     * 7
     *
     * @apiNote 思路：
     * 1.
     */
    public static int code(ArrayList<Node> nodes, Node start, Node end) {

        return minDistance;
    }

    /**
     * 回溯
     */
    public static void backtrace() {

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int S = scanner.nextInt();
        int T = scanner.nextInt();
        Node node;
        ArrayList<Node> nodes = new ArrayList<>();
        Node start = null;
        Node end = null;
        for (int i = 0; i < N; i++) {
            int id = scanner.nextInt();
            int target = scanner.nextInt();
            int distance = scanner.nextInt();
            node = new Node(id, target, distance);
            if (node.getId() == S) {
                start = node;
            }
            if (node.getId() == T) {
                end = node;
            }
            nodes.add(node);
        }
        System.out.println(code(nodes, start, end));
    }
}
