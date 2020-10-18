package com.bins.question.list;

/**
 * @author leo-bin
 * @date 2020/7/20 11:31
 * @apiNote 删除链表的倒数第N个节点
 * 来源：leetcode-19
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

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
     * 1.给定一个链表
     * 2.删除链表的倒数第 n 个节点
     * 3.并且返回链表的头结点
     * 4.给定的 n 保证是有效的
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5
     * <p>
     * 进阶：你能尝试使用一趟扫描实现吗？
     *
     * @apiNote 思路：
     * 1.暴力
     * 2.一次遍历记录链表的长度len
     * 3.然后再来一次遍历，从头开始找正数第:len-n+1个数
     * 4.时间复杂度：O(n)
     * 5.空间复杂度：O(1)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        ListNode current = head, dump = new ListNode(0), pre;
        dump.next = head;
        pre = dump;
        int count = 1;
        while (current != null) {
            if (count == (len - n + 1)) {
                //删除节点
                pre.next = current.next;
                break;
            }
            count++;
            pre = current;
            current = current.next;
        }
        return dump.next;
    }


    /**
     * 解法二，快慢指针
     *
     * @apiNote 思路：
     * 1.我们设置两个指针p1，p2，p1先走，p2后走
     * 2.那p1先走多少个节点呢？答案是：n-1
     * 3.当p1走完了，此时的p2指向的节点就是倒数第n个节点！
     * 4.我们假设我们要找倒数第n个节点，现在一共有k个节点
     * 5.所以就相当于找正数的第x个节点，x=k-n+1个节点
     * 6.变形一下，得到：k-x=n-1
     * 7.也就是说，p1走的步数等于k，p2走的步数就是x
     * 8.那么它们之间就应该相差：n-1个节点！
     * 9.时间复杂度：O(n)
     * 10.空间复杂度：O(1)
     */
    public static ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode p1 = head;
        ListNode p2 = dump, pre = dump;
        int count = 0;
        while (p1 != null) {
            if (count >= (n - 1)) {
                pre = p2;
                p2 = p2.next;
            }
            count++;
            p1 = p1.next;
        }
        //删除
        pre.next = p2.next;
        return dump.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        int n = 2;
        ListNode newHead = removeNthFromEnd(head, n);
        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
}
