package com.bins.javabasic.collection.list;

/**
 * @author leo-bin
 * @date 2020/2/13 9:54
 * @apiNote 自定义实现一个简单的线性链表
 */
public class LinkedList {

    /**
     * 先定义一个头节点
     */
    Node head = null;

    /**
     * 增加一个节点
     *
     * @param data
     */
    public void addNode(int data) {
        //初始化这个新的节点
        Node newNode = new Node(data);
        //如果此时的头结点为空的话，也就是说这个新节点是第一个节点，那就让新节点成为这个链表的头结点
        if (head == null) {
            head = newNode;
            return;
        }
        //先定义一个tmp节点指向原来的头结点
        Node tmp = head;
        //如果原来的头结点的next节点不为空的话，也就是说头结点的下一个节点已经有其他的节点了
        while (tmp.next != null) {
            //循环赋值，直到tmp指向一个next节点为空的节点为止
            tmp = tmp.next;
        }
        //新的节点指向前一个节点的next节点
        tmp.next = newNode;
    }

    /**
     * 删除一个下标为index的节点
     *
     * @param index 节点的下标
     * @return 是否删除成功
     */
    public boolean deleteNode(int index) {
        if (index < 0 || index > length()) {
            return false;
        }
        //index为1，那就是删除头结点，让head节点的next节点成为新的head节点
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        Node tmpPre = head;
        Node tmp = tmpPre.next;
        while (tmp != null) {
            if (i == index) {
                tmpPre.next = tmp.next;
                return true;
            }
            i++;
            //节点都往后移动一个
            tmp = tmp.next;
            tmpPre = tmp;
        }
        return false;
    }

    /**
     * 求本链表的长度
     *
     * @return 长度
     */
    public int length() {
        int length = 0;
        //tmp指向链表的头结点
        Node tmp = head;
        while (tmp != null) {
            length++;
            //tmp节点往后移一个，指向下一个节点
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 返回下标为index的节点中的数据
     *
     * @param index 节点下标
     * @return 节点数据
     */
    public int getByIndex(int index) {
        //i代表链表中节点的个数
        int i = 0;
        //不符合条件直接返回-1
        if (index < 0 || index > length()) {
            return -1;
        }
        Node tmp = head;
        while (tmp != null) {
            i++;
            if (i == index) {
                return tmp.data;
            }
            tmp = tmp.next;
        }
        return -1;
    }

    /**
     * 打印本链表中的数据
     */
    public void printList() {
        Node tmp = head;
        //节点的下标
        int index = 0;
        while (tmp != null) {
            index++;
            System.out.println("节点：" + index + "=" + tmp.data);
            tmp = tmp.next;
        }
    }
}
