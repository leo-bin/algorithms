package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/5/19 12:05
 * @apiNote 移除链表中的元素
 * 来源：leetcode-203
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {

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
     * 1.删除链表中等于给定值 val 的所有节点
     * <p>
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.对于这种题目其实有点小坑，就是可能头结点就是我们目标值
     * 3.所以一般的做法就是一开始就在原链表的头结点前加一个虚节点
     * 4.然后弄一个cur节点，开始往后面遍历
     * 5.但是需要判断cur.next.val
     * 6.时间复杂度：O(n)
     * 7.空间复杂度：O(1)
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.data == val) {
                //移除
                cur.next = cur.next.next;
            } else {
                //否则往后面走,这里之所以用else是因为要考虑到val连续出现的情况
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {

    }
}
