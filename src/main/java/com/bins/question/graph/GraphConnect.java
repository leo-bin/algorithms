package com.bins.question.graph;

import java.util.ArrayList;

/**
 * @author leo-bin
 * @date 2020/9/17 16:15
 * @apiNote 图的连通性判断
 */
public class GraphConnect {

    /**
     * 节点
     */
    public class Node {
        int label;
        ArrayList<Node> neighbors = new ArrayList<>();

        public Node(int label) {
            this.label = label;
        }
    }

    ArrayList<Node> nodes = new ArrayList<>();
    boolean hasLine = false;

    public boolean checkPath(Node a, Node b) {
        return hasPath(a, b) || hasPath(b, a);
    }

    public boolean hasPath(Node a, Node b) {
        if (a == b || hasLine) {
            hasLine = true;
            return true;
        } else {
            if (!nodes.contains(a)) {
                nodes.add(a);
            } else {
                return false;
            }
        }
        for (int i = 0; i < a.neighbors.size(); i++) {
            hasPath(a.neighbors.get(i), b);
        }
        return hasLine;
    }

    public static void main(String[] args) {

    }
}
