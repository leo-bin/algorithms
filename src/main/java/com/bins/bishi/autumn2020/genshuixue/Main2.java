package com.bins.bishi.autumn2020.genshuixue;

/**
 * @author leo-bin
 * @date 2020/8/7 18:24
 * @apiNote
 */
public class Main2 {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 将两个升序链表合并为一个新的 升序
     * 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public Node mergeTwoLists(Node n1, Node n2) {
        //递归结束条件
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.data <= n2.data) {
            n1.next = mergeTwoLists(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeTwoLists(n1, n2.next);
            return n2;
        }
    }


    public static void main(String[] args) {
        Main2 main2 = new Main2();

        Node n1 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(4);
        n1.next = node1;
        node1.next = node2;

        Node n2 = new Node(1);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        n2.next = node3;
        node3.next = node4;

        Node head = main2.mergeTwoLists(n1, n2);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
