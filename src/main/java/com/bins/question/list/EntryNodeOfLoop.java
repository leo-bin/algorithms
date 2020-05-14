package com.bins.question.list;


import java.util.HashSet;

/**
 * @author leo-bin
 * @date 2020/5/12 10:23
 * @apiNote 链表中环的入口节点
 */
public class EntryNodeOfLoop {


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
     * 1.给一个链表，若其中包含环，请找出该链表的环的入口结点
     * 2.否则，输出null。
     *
     * @apiNote 思路：
     * 1.使用set判断是否有环
     * 2.假设一个链表为：3->2->0->4,并且最后一个节点指向第二个节点形成了环
     * 3.我们只要一次性遍历链表，每一次set.add(node)
     * 4.并且通过set.contains(node)来判断当前的节点是否出现过
     * 5.如果出现过，说明成环了，而当前进行判断的节点就是环的入口节点
     * 6.在这里就是当遍历最后一个节点4的时候，因为有环，所有4的下一个节点是2
     * 7.但是2已经出现过了，所以成环了，然后retun2这个节点就行
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        ListNode current = pHead;
        while (current != null) {
            if (set.contains(current)) {
                //成环了
                return current;
            } else {
                set.add(current);
            }
            current = current.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        ListNode result = entryNodeOfLoop(head);
        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("没有环！");
        }
    }
}
