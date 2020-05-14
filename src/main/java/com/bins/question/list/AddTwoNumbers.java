package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/5/8 15:19
 * @apiNote 两数相加（数字都是以链表的形式出现）
 * 来源：leetcode-2
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbers {

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
     * 1.给出两个非空的链表用来表示两个非负的整数
     * 2.其中，它们各自的位数是按照逆序的方式存储的
     * 3.并且它们的每个节点只能存储
     * 一位数字
     * 4.如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和
     * 5.可以假设除了数字 0 之外，这两个数都不会以0开头
     * <p>
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @apiNote 思路：
     * 1.这个题目无非是考察我们对链表的操作
     * 2.需要注意的是我们一定要考虑到当两个数相加之后大于10的情况需要进位
     * 3.也就是说，如果是35(5->3)+87(7->8)
     * 4.这个结果是等于122(2->2->1)，而不是122(12->11)
     * 5.也就是说只要当相加之和小于10时才能直接进行相加，否则需要记录上一组数相加时的进位
     * 6.所以基本思路就是我们从头到尾去遍历两个链表就行
     * 7.但是需要实时记录进位的产生，如果进位>0，说明相加>10
     * 8.所以我们需要取当前相加之和的最后一位作为当前的节点加入result链表中
     * 9.同时将第一位作为进位保存起来，方便下次求和的时候加入计算就行
     * 10.时间复杂度：O(n)
     * 11.空间复杂度：O(1)
     */
    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        //结果的头结点
        ListNode result = new ListNode(-1);
        //当前节点
        ListNode currentNode = result;
        //记录每一组相加时的进位情况
        int carry = 0;
        while (list1 != null || list2 != null || carry != 0) {
            //1.链表没了，那就默认取0
            int list1Value = list1 != null ? list1.data : 0;
            int list2Value = list2 != null ? list2.data : 0;
            //2.计算每一轮相加的结果
            int currentSum = list1Value + list2Value + carry;
            //3.求进位
            carry = currentSum / 10;
            //4.得到相加结果并加入result中（%10是因为可能会有进位）
            ListNode tmp = new ListNode(currentSum % 10);
            currentNode.next = tmp;
            currentNode = tmp;
            //5.链表往后走
            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}
