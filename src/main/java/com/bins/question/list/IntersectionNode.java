package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/8/7 10:39
 * @apiNote
 */
public class IntersectionNode {

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
     * 1.编写一个程序，找到两个单链表相交的起始节点
     * <p>
     * 示例 1：
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：
     * 相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * <p>
     * 示例 2：
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：
     * 相交节点的值为 2 （注意，如果两个链表相交则不能为 0）
     * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]
     * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点
     * <p>
     * 示例 3：
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：
     * 从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
     * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null
     * <p>
     * 注意：
     * 1.如果两个链表没有交点，返回 null
     * 2.在返回结果后，两个链表仍须保持原有的结构
     * 3.可假定整个链表结构中没有循环
     * 4.程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存
     *
     * @apiNote 思路：
     * 1.
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //特判
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode headB = new ListNode(3);
        headB.next = node3;

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println("相交节点是：" + result.data);
    }
}
