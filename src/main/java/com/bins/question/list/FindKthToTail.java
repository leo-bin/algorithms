package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/4/8 12:14
 * @apiNote 链表中倒数第k个节点
 */
public class FindKthToTail {


    public static class ListNode {
        int data;
        ListNode next = null;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 题目描述：输入一个链表，输出该链表中倒数第k个结点
     *
     * @apiNote 思路：
     * 1.解法一，暴力
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        //鲁棒
        if (k <= 0) {
            return null;
        }
        if (head == null) {
            return head;
        }
        //1.一次遍历求链表的长度
        int len = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        if (k > len) {
            return null;
        }
        //2.倒数第k个节点，就是正数（len-k+1）个节点
        tmp = head;
        int count = 1;
        while (count <= len) {
            if (count == (len - k + 1)) {
                return tmp;
            }
            tmp = tmp.next;
            count++;
        }
        return head;
    }

    /**
     * 题目描述：输入一个链表，输出该链表中倒数第k个结点
     *
     * @apiNote 思路：
     * 1.解法二，快慢指针
     * 2.设置两个指针p1，p2
     * 3.p1先走，p2后走，中间隔k-1个节点之后p2在走
     * 4.等p1走完了，p2所在的位置就是倒数第k个节点
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static ListNode findKthToTail2(ListNode head, int k) {
        //鲁棒
        if (k <= 0) {
            return null;
        }
        if (head == null) {
            return head;
        }
        //设置两个指针，p1先走，p2后走，中间隔k-1个节点
        ListNode p1;
        ListNode p2;
        p1 = head;
        p2 = head;
        int count = 1;
        while (p1.next != null) {
            if (count > (k - 1)) {
                p2 = p2.next;
            }
            p1 = p1.next;
            count++;
        }
        if (k > count) {
            return null;
        }
        return p2;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode node = findKthToTail2(head, 4);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("找不到");
        }
    }
}
