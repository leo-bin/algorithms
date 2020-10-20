package com.bins.question.list;

import java.util.LinkedList;

/**
 * @author leo-bin
 * @date 2020/10/20 16:06
 * @apiNote 重排列表
 * 来源：leetcode-143
 * 链接：https://leetcode-cn.com/problems/reorder-list/
 */
public class ReOrderList {

    /**
     * 链表内部类
     **/
    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 题目描述：
     * 1.给定一个单链表 L：L0→L1→…→Ln-1→Ln
     * 2.将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * 3.你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     * <p>
     * 示例 1:
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3
     * <p>
     * 示例 2:
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3
     *
     * @apiNote 思路：
     * 1.首先想到了一种很low的做法，就是我们利用额外的内存比如说双向链表
     * 2.这样一来每次都能够直接获取到头结点和尾节点
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static void reOrderList(ListNode head) {
        //特判
        if (head == null) {
            return;
        }
        //先存双向链表
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        //连接头和尾节点
        ListNode first, last;
        while (!list.isEmpty()) {
            first = list.pollFirst();
            last = list.pollLast();
            if (first != null) {
                first.next = last;
            }
            if (last != null) {
                last.next = list.isEmpty() ? null : list.peekFirst();
            }
        }
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.之前的解法太过取巧了
     * 2.我们尝试不用额外的内存空间去做
     * 3.假设链表是：1->2->3->4
     * 4.我们可以将链表一分为二变成前后两个链表list1=1->2和list2=3->4
     * 5.然后将list2反转得到：4->3
     * 6.接下来只要按照顺序合并两个链表即可
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(1)
     */
    public static void reOrderListV2(ListNode head) {
        //特判
        if (head == null) {
            return;
        }
        //找中间节点并分开链表
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        //反转链表2
        ListNode list1 = head;
        ListNode list2 = reverseList(mid);
        //合并list1和list2
        ListNode t1, t2;
        while (list1 != null && list2 != null) {
            t1 = list1.next;
            t2 = list2.next;

            list1.next = list2;
            list1 = t1;

            list2.next = t1;
            list2 = t2;
        }
    }


    /**
     * 反转链表
     */
    public static ListNode reverseList(ListNode head) {
        //递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        reOrderListV2(head);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
