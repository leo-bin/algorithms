package com.bins.question.print;

import java.util.Stack;

/**
 * @author leo-bin
 * @date 2020/3/27 23:09
 * @apiNote 从尾到头打印链表
 */
public class PrintListFromTail2Head {


    /**
     * 定义节点内部类
     */
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 从尾到头打印一个链表(解法一：循环+栈)
     *
     * @apiNote 思路：
     * 1.顺序循环+栈解决
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(n)
     */
    public static void printListFromTail2Head(Node head) {
        Node tmp = head;
        Stack<Node> stack = new Stack<>();
        if (tmp != null) {
            //1.头结点先入栈
            stack.push(tmp);
            while (tmp.next != null) {
                tmp = tmp.next;
                //2.其余节点一次进栈
                stack.push(tmp);
            }
            //3.遍历栈，反序输出
            while (!stack.isEmpty()) {
                print(stack.pop());
            }
        }
    }


    /**
     * 从尾到头打印一个链表
     *
     * @apiNote 思路：
     * 1.递归解决
     * 2.时间复杂度为：O(n)
     * 3.空间复杂度：O(n)
     */
    public static String printListFromTail2Head2(Node head) {
        StringBuilder data = new StringBuilder();
        //1.递归结束条件
        if (head != null && head.next == null) {
            return Integer.toString(head.data);
        }
        if (head == null) {
            return null;
        }
        data.append(printListFromTail2Head2(head.next));
        data.append(head.data);
        return data.toString();
    }


    /**
     * 打印数据
     */
    public static void print(Node node) {
        if (node != null) {
            System.out.println("此节点的数据为：" + node.data);
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println("解法一：从尾到头打印链表：");
        printListFromTail2Head(head);
        System.out.println("解法二：从尾到头打印链表：" + printListFromTail2Head2(head));
    }
}
