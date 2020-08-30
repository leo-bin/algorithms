package com.bins.question.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/8/30 20:15
 * @apiNote 是否为回文链表
 * 来源：leetcode-234
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindromeList {

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
     * 1.请判断一个链表是否为回文链表
     * <p>
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * <p>
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     *
     * @apiNote 思路：
     * 1.先考虑暴力解法，转换成一个可迅速根据索引来遍历节点的形式
     * 2.比如说使用一个容器存所有的节点，然后使用双指针的方式求是否是回文
     * 3.时间复杂度：O(n)
     * 4.空间复杂度：O(n)
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法二
     *
     * @apiNote 思路：
     * 1.接下来我们考虑优化下空间
     * 2.这里看了评论的题解，发现可以通过反转后半部分，然后验证后半部分是否和前半部分一摸一样
     * 3.比如说：1->2-2>3
     * 4.它的中间节点是第二个2，我们进行反转得到：1->2->1->2
     * 5.很明显后半部分和前半部分是一样的
     * 6.要想实现反转需要找到中间节点，这里可以使用快慢指针的方式求
     * 7.反转链表我们可以用递归来实现
     * 8.之后我们从中间节点和head节点开始遍历，从前往后走，判断是否一样
     * 9.总体的时间复杂度：O(1/2*n)
     * 10.空间复杂度：O(n)
     */
    public static boolean isPalindromeV2(ListNode head) {
        //特判
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针找中间节点（结束之后的slow指向的就是中间节点）
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转后半部分
        slow = reverse(slow.next);
        //校验后半部分和前半部分是否一致
        while (slow != null) {
            if (slow.data != head.data) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 链表反转
     */
    public static ListNode reverse(ListNode head) {
        //递归结束条件
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {

    }
}
