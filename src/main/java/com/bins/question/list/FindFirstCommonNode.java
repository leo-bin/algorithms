package com.bins.question.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/4/12 9:12
 * @apiNote 找出两个链表的第一个公共节点
 */
public class FindFirstCommonNode {


    /**
     * 链表内部类
     **/
    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }


    /**
     * 题目描述：
     * 1.输入两个链表，找出它们的第一个公共结点
     * 2.注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的
     *
     * @apiNote 思路：
     * 1.这里需要注意下公共节点是什么意思
     * 2.比如链表1为{1，2，3，4，5}，链表2为{1，6，7，4，5}，那么公共节点就是4
     * 3.相等于两个链表公用同一个节点，所以可以抽象的理解为呈现为一个Y字型
     * 4.也就是两个链表从公共节点开始的所有节点都是同一个
     * 5.这里使用集合来解，先一次遍历链表1，将所有元素存在一个List中（这里是使用ListNode对象本身作为元素）
     * 6.然后顺序遍历链表2，遍历的同时判断链表2中的元素是否存在于链表1中
     * 7.如果存在返回当前节点，遍历完不存在返回null
     * 8.时间复杂度：O(n)
     * 9.空间复杂度：O(n)
     */
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        List<ListNode> listNodes = new ArrayList<>();
        //1.链表1全部存List
        ListNode tmp = pHead1;
        while (tmp != null) {
            listNodes.add(tmp);
            tmp = tmp.next;
        }
        //2.遍历链表2，同时判断
        while (pHead2 != null) {
            if (listNodes.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }


    public static void main(String[] args) {
        //定义链表1
        ListNode pHead1 = new ListNode(1);
        ListNode p1Node1 = new ListNode(2);
        ListNode p1Node2 = new ListNode(3);

        //定义公共节点
        ListNode commonNode1 = new ListNode(4);
        ListNode commonNode2 = new ListNode(5);

        //定义链表2
        ListNode pHead2 = new ListNode(1);
        ListNode p2Node1 = new ListNode(6);
        ListNode p2Node2 = new ListNode(7);


        //初始化公共节点
        commonNode1.next = commonNode2;
        commonNode2.next = null;

        //初始化链表1
        pHead1.next = p1Node1;
        p1Node1.next = p1Node2;
        p1Node2.next = commonNode1;

        //初始化链表2
        pHead2.next = p2Node1;
        p2Node1.next = p2Node2;
        p2Node2.next = commonNode1;

        //公共节点应该是commonNode1，data等于4
        ListNode result = findFirstCommonNode(pHead1, pHead2);
        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("没有公共节点存在！！");
        }
    }

}
