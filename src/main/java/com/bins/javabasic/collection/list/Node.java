package com.bins.javabasic.collection.list;


import lombok.Data;

/**
 * @author leo-bin
 * @date 2020/2/13 9:47
 * @apiNote 链表的基本节点类
 */
@Data
public class Node {

    /**
     * 指向下一个节点位置的指针(本质上还是一个节点)
     */
    Node next = null;

    /**
     * 本节点的所存储的数据
     */
    int data;

    public Node(int data) {
        this.data = data;
    }
}
