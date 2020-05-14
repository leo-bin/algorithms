package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/4/9 13:53
 * @apiNote 合并两个排序的链表
 */
public class MergeList {

    /**
     * 节点类
     */
    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int date) {
            this.data = date;
        }
    }

    /**
     * 题目描述：
     * 1.输入两个单调递增的链表
     * 2.输出两个链表合成后的链表
     * 3.当然我们需要合成后的链表满足单调不减规则
     *
     * @apiNote 思路：
     * 1.解法一，遍历，A,B两个链表，从A和B的头节点开始依次往后遍历，每次都将比较小的节点设为头结点
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static ListNode mergeList(ListNode list1, ListNode list2) {
        //鲁棒
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        ListNode current = null;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                if (newHead == null) {
                    newHead = list1;
                    current = list1;
                } else {
                    current.next = list1;
                    current = list1;
                }
                list1 = list1.next;
            } else {
                if (newHead == null) {
                    newHead = list2;
                    current = list2;
                } else {
                    current.next = list2;
                    current = list2;
                }
                list2 = list2.next;
            }
            if (list1 == null) {
                current.next = list2;
            } else {
                current.next = list1;
            }
        }
        return newHead;
    }


    /**
     * 题目描述：
     * 1.输入两个单调递增的链表
     * 2.输出两个链表合成后的链表
     * 3.当然我们需要合成后的链表满足单调不减规则
     *
     * @apiNote 思路：
     * 1.递归解题
     * 2.时间复杂度：O(1)
     * 3.空间复杂度：O(m+n)
     */
    public static ListNode mergeV2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.data <= list2.data) {
            list1.next = mergeV2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeV2(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        list1.next = node1;
        node1.next = node2;
        node2.next = null;

        ListNode list2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        list2.next = node3;
        node3.next = null;

       /* ListNode result = mergeList(list1, list2);
        System.out.println("解法一：循环");
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }*/

        ListNode resultV2 = mergeV2(list1, list2);
        System.out.println("解法二：递归");
        while (resultV2 != null) {
            System.out.println(resultV2.data);
            resultV2 = resultV2.next;
        }
    }
}
