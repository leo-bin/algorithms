package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/10/13 18:26
 * @apiNote 两两交换链表中的节点
 * 来源：leetcode-24
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapList {

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
     * 1.给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 2.你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     * <p>
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     *
     * @apiNote 思路：
     * 1.这题有点像链表反转，但是不同的是这里涉及到三个节点之间的关系
     * 2.因为我们只需要改变相邻节点之间的关系，所以我们每次都只要修改当前节点和当前节点的下一个节点之间的关系就可
     * 3.可以以一个最简单的情况进行思考，假设链表是：1->2-null
     * 4.当前节点head就是1，next就是2，下一次递归没有戏直接返回了，所以我们现在只要改变hea单核next之间的关系即可实现反转
     */
    public static ListNode swapPairs(ListNode head) {
        //递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {

    }
}
