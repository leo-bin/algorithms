package com.bins.question.list;

import java.util.Arrays;

/**
 * @author leo-bin
 * @date 2020/3/17 22:01
 * @apiNote 反转链表
 * 来源：leetcode-206
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    /**
     * 链表节点
     */
    public class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    /**
     * 反转链表
     *
     * @apiNote 思路：
     * 1.迭代解题
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public ListNode reverseList(ListNode head) {
        //保证代码的鲁棒性
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode tmp;
        while (curNode != null) {
            tmp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = tmp;
        }
        return preNode;
    }


    /**
     * 反转链表：
     *
     * @apiNote 思路：
     * 1.使用递归
     * 2.通过不断的改变倒数第一个节点和倒数第二个节点的指向关系来反转链表
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static ListNode reverseList2(ListNode head) {
        //1.递归结束条件：当前节点没有next节点或者当前节点是null时将当前节点return
        if (head == null || head.next == null) {
            return head;
        }
        //2.找到一个递归函数不断调用自己：将当前节点的next节点作为下一次调用的参数
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        int[] nums = new int[4];
        for (int i = 0; i <= 3; i++) {
            nums[i] = i;
        }
        System.out.println(Arrays.toString(nums));
    }
}
