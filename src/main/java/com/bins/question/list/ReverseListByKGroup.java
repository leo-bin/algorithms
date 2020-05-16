package com.bins.question.list;


/**
 * @author leo-bin
 * @date 2020/5/16 17:31
 * @apiNote k个一组反转链表
 * 来源：leetcode-25
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 */
public class ReverseListByKGroup {

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
     * 1.给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表
     * 2.k 是一个正整数，它的值小于或等于链表的长度
     * 3.如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 示例：
     * 给你这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     * 说明：
     * 1.你的算法只能使用常数的额外空间。
     * 2.你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
     *
     * @apiNote 思路：
     * 1.本道题的思路其实不难想到，无非就是将原来的链表分组，然后组内进行反转，最后每一组连起来就行
     * 2.但是，站着说话不腰疼，光想是没有用的！当你真正实现起来时你会发现，md真tm的难！
     * 3.首先分组的问题，我们可以内部写一个for循环，当达到k值的时候我们就行可以进行反转了
     * 4.组内反转很简单，只要断开该组的最后一个节点和后面的节点的联系，这样子，整个组就是一个完整的链表！
     * 5.一个完整的链表的反转那就很简单了，递归或者迭代随便选！
     * 6.至于怎么连起来，这就有点难了呀！
     * 7.我们其实可以设三个指针，每次组内反转之前，我们要找到这个组的头结点start，最后一个节点end，还有end节点的next节点
     * 8.在反转之前就可以断开end和end的next节点的联系了，然后组内反转
     * 9.反转完毕之后，这个时候的start就是整个链表的最后一个节点了，我们只需要让它和之前保存过的next节点连接就行
     * 10.时间复杂度：O(n)(实际上是2N)
     * 11.空间复杂度：O(1)
     */
    public static ListNode reverseListByKGroup(ListNode head, int k) {
        //设置一个虚节点作为开头
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode endNode = dummy;
        while (endNode.next != null) {
            //1.找到分组的位置
            for (int i = 0; i < k && endNode != null; i++) {
                endNode = endNode.next;
            }
            if (endNode == null) {
                break;
            }
            //2.记录当前的组的开始和下一个组的开始
            ListNode start = preNode.next;
            ListNode next = endNode.next;
            //3.断开两个组的联系
            endNode.next = null;
            //4.组内反转
            preNode.next = reverse(start);
            //5.重新连接两个组的联系
            start.next = next;
            //6.复原，开始下一组的反转
            preNode = start;
            endNode = preNode;
        }
        return dummy.next;
    }


    /**
     * 反转链表
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    public static void main(String[] args) {

    }
}
