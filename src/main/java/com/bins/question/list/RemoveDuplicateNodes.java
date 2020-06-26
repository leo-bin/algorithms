package com.bins.question.list;

import java.util.HashSet;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/6/26 11:06
 * @apiNote 删除重复节点
 * 来源：leetcode-02.01
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class RemoveDuplicateNodes {

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
     * 1.写代码，移除未排序链表中的重复节点。
     * 2.保留最开始出现的节点。
     * <p>
     * 示例1:
     * 输入：[1, 2, 3, 3, 2, 1]
     * 输出：[1, 2, 3]
     * <p>
     * 示例2:
     * 输入：[1, 1, 1, 1, 2]
     * 输出：[1, 2]
     * <p>
     * 提示：
     * 1.链表长度在[0, 20000]范围内。
     * 2.链表元素在[0, 20000]范围内。
     * <p>
     * 进阶：
     * 如果不得使用临时缓冲区，该怎么解决？
     *
     * @apiNote 思路：
     * 1.暴力+哈希表
     * 2.先存根节点进去，然后直接一次遍历
     * 3.每次都先判断当前节点是否存在于表中
     * 4.如果存在于，说明当前节点就是我们要删除的节点，没有给出直接前驱节点怎么删除？
     * 5.简单！我们自己设了一个前驱节点不就行了！如果不存在，就添加进哈希表，同时更新前驱节点
     * 6.最后返回head节点就行
     * 7.时间复杂度：O(n)
     * 8.空间复杂度：O(n)
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        ListNode current = head;
        ListNode preNode = head;
        HashSet<Integer> set = new HashSet<>();
        while (current != null) {
            if (set.contains(current.data)) {
                //删除当前节点
                preNode.next = current.next;
            } else {
                set.add(current.data);
                //更新前驱节点
                preNode = current;
            }
            //cur往后移
            current = current.next;
        }
        return head;
    }


    public static void main(String[] args) {

    }
}
