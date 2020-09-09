package com.bins.question.list;

import java.util.PriorityQueue;

/**
 * @author leo-bin
 * @date 2020/9/9 15:42
 * @apiNote 合并K个链表
 * 来源：leetcode-23
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

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
     * 1.给你一个链表数组，每个链表都已经按升序排列。
     * 2.请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * <p>
     * 示例 1
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * <p>
     * 示例 2
     * 输入：lists = []
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     *
     * @apiNote 思路：
     * 1.这个和归并排序很像，我们可以用分治法去写
     * 2.但是这里先写一种比较新奇的思路
     * 3.我们用一个小顶堆去做，先存所有表头节点
     * 4.然后接着遍历小顶堆，拿出堆顶的节点，此节点就是当前的最小节点
     * 5.我们从当前节点开始往下面遍历，遇到非空节点就加入小顶堆
     * 6.时间复杂度：O(n*log(n))
     * 7.空间复杂度：O(n)
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        //特判
        if (lists.length <= 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        //建最小堆
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.data - o2.data);
        //全部链表头结点入堆
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.poll();
            cur.next = next;
            cur = cur.next;
            next = next.next;
            if (next != null) {
                minHeap.add(next);
            }
        }
        return dummy.next;
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.分治法
     * 2.类似于归并排序，先分治，分治到最后只剩下两个头结点，然后两两之间进行归并
     * 3.时间复杂度：O(n*log(n))
     * 4.空间复杂度：O(n)
     */
    public static ListNode mergeKListsV2(ListNode[] lists) {
        //递归结束条件
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return merge2Lists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        //将原来的数组分成两部分
        ListNode[] list1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            list1[i] = lists[i];
        }
        ListNode[] list2 = new ListNode[lists.length - mid];
        for (int i = mid, j = 0; j < list2.length && i < lists.length; i++, j++) {
            list2[j] = lists[i];
        }
        return merge2Lists(mergeKListsV2(list1), mergeKListsV2(list2));
    }

    /**
     * 归并两个链表
     */
    public static ListNode merge2Lists(ListNode head1, ListNode head2) {
        //递归结束条件
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data <= head2.data) {
            head1.next = merge2Lists(head1.next, head2);
            return head1;
        } else {
            head2.next = merge2Lists(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {

    }
}
