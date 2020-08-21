package com.bins.bishi.autumn2020.youzan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author leo-bin
 * @date 2020/8/20 17:54
 * @apiNote
 */
public class Main1 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 题目描述
     * 请判断一个链表是否为回文链表
     * <p>
     * 示例1
     * 输入
     * {1,2}
     * 输出
     * false
     * <p>
     * 示例2
     * 输入
     * {1,2,2,1}
     * 输出
     * true
     * <p>
     * 备注:
     * 空链表以及只含单个元素的链表可以认为是回文链表
     *
     * @apiNote 思路：
     * 1.
     */
    public static boolean isPalindrome(ListNode head) {
        //特判
        if (head == null || head.next == null) {
            return true;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            if (list.get(i).val != list.get(j).val) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        System.out.println(isPalindrome(head));
    }
}
