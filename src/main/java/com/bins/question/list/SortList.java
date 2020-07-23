package com.bins.question.list;


/**
 * @author leo-bin
 * @date 2020/7/23 9:37
 * @apiNote 排序链表
 * 来源：leetcode-148
 * 链接：https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

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
     * 1.在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
     * <p>
     * 示例 1:
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * <p>
     * 示例 2:
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * @apiNote 思路：
     * 1.一看这世间复杂度的限制，我们能采用的解法就不多了
     * 2.快排，堆排，归并排序都可以
     * 3.但是这里不是数组，堆排直接淘汰
     * 4.快排也要用到数组的头尾节点，这里先不考虑
     * 5.我们使用归并排序进行分治处理！
     * 6.归并首先要做的就是分治！
     * 7.按照之前数组的归并我们采用的是复制的方式进行分治
     * 8.但是这里不是数组，我们不好复制
     * 9.那就只能通过递归，每次找中点，然后从中点切开，就形成了分治好的两个链表
     * 10.剩下的就简单了，不就是直接合并两个链表吗
     * 11.时间复杂度：O(n*(log(n)))
     * 12.空间复杂度：O(log(n))
     */
    public static ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }


    /**
     * 归并排序
     *
     * @apiNote 思路：
     * 1.不断找链表的中间节点进行分治
     * 2.这里尤其需要注意一个技巧就是通过快慢指针来查找中间节点
     * 3.快指针每次走两步，满指针每次走一步
     * 4.当快指针走完了，那么慢指针走的路程就一定是整个路程的一半！
     * 5.此时慢指针指向的就一定是中间节点
     * 6.但是需要注意取分奇数和偶数的情况
     */
    public static ListNode mergeSort(ListNode head) {
        //递归结束条件
        if (head.next == null) {
            return head;
        }
        //通过快慢指针找到当前链表的中间节点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //从中间开始切断关系
        slow.next = null;
        //继续分治
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(tmp);
        //开始合并两个链表
        return merge(left, right);
    }

    /**
     * 合并两个链表
     */
    public static ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = left != null ? left : right;
        return result.next;
    }


    public static void main(String[] args) {

    }
}
