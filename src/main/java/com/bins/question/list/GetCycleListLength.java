package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/5/12 11:22
 * @apiNote 求环形链表的环形长度
 */
public class GetCycleListLength {

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
     * 判断是否有环，并且返回环的长度
     *
     * @apiNote 思路：
     * 1.判断是否有环可以使用快慢指针来做
     * 2.当p1和p2都指向同一个节点的时候说明，这是一个有环的链表
     * 3.然后紧接着，固定p2不动，一步一步循环的移动p1
     * 4.当p1再次和p2相遇的时候，p1正好走了一个环，我们只要计数就行
     * 5.时间复杂度：O(n)
     * 6.空间复杂度：O(1)
     */
    public static int cycleLength(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        int count = 1;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = p1.next;
                while (p1 != p2) {
                    count++;
                    p1 = p1.next;
                }
                return count;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println("该环的长度是：" + cycleLength(head));
    }
}
