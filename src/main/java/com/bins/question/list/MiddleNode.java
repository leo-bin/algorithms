package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/10/20 16:50
 * @apiNote 链表的中间节点
 * 来源：leetcode-876
 * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleNode {

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
     * 1.给定一个带有头结点head的非空单链表，返回链表的中间结点
     * 2.如果有两个中间结点，则返回第二个中间结点
     * <p>
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为3(测评系统对该结点序列化表述是 [3,4,5])
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL
     * <p>
     * 示例 2：
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点4(序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点
     * <p>
     * 提示：
     * 给定链表的结点数介于1和100之间
     *
     * @apiNote 思路：
     * 1.使用快慢指针找中间节点
     * 2.慢指针每次走一步，快指针每次走两步
     * 3.当快指针走完的时候此时慢指针就位于链表的中间节点
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
