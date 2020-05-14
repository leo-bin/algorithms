package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/4/25 20:59
 * @apiNote 删除链表中重复的节点
 */
public class DeleteDuplicationNode {


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
     * 1.在一个排序的链表中，存在重复的结点
     * 2.请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
     * 3.例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.时间复杂度：O(n)
     * 3.空间复杂度：O(1)
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = pHead;
        ListNode current = preHead;
        ListNode nextNode = pHead;
        while (nextNode != null) {
            if (nextNode.next != null && nextNode.data == nextNode.next.data) {
                while (nextNode.next != null && nextNode.data == nextNode.next.data) {
                    nextNode = nextNode.next;
                }
                //删除
                current.next = nextNode.next;
                nextNode = nextNode.next;
            } else {
                current = current.next;
                nextNode = nextNode.next;
            }
        }
        return preHead.next;
    }


    public static void main(String[] args) {

    }
}
