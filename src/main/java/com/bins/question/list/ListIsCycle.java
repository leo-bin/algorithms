package com.bins.question.list;

import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/3/23 20:27
 * @apiNote 判断链表是否有环
 */
public class ListIsCycle {

    /**
     * 节点类
     */
    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    /**
     * 判断是否有环（解法一，HashSet判断重复）
     *
     * @apiNote 思路：
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(n)
     */
    public static boolean isCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<Node> set = new HashSet<>();
        set.add(head);
        Node tmp;
        while (head.next != null) {
            tmp = head.next;
            if (set.contains(tmp)) {
                return true;
            }
            set.add(tmp);
        }
        return false;
    }


    /**
     * 判断是否有环（解法二，快慢指针）
     *
     * @apiNote 思路：
     * 1.时间复杂度：O(n)
     * 2.空间复杂度：O(1)
     */
    public static boolean isCycle2(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        //慢指针，每次移动1个位置
        Node p1 = head;
        //快指针，每次移动2个位置
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println("解法一：是否有环：" + isCycle(head));
        System.out.println("解法二：是否有环：" + isCycle2(head));
    }
}
