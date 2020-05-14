package com.bins.javabasic.collection.list;

/**
 * @author leo-bin
 * @date 2020/2/13 11:00
 * @apiNote 测试入口
 */
public class MainTest {

    public static void main(String[] args) {
        //初始化一个链表
        LinkedList linkedList = new LinkedList();
        //向链表中插入一些数据
        for (int i = 1; i < 5; i++) {
            linkedList.addNode(i);
        }
        //打印看看
        linkedList.printList();
        //获取链表中下标为2的节点的数据
        System.out.println("下标为2的节点的数据为：" + linkedList.getByIndex(2));
        //删除下标为2的节点
        if (linkedList.deleteNode(2)) {
            System.out.println("下标为2的节点已经成功删除！");
        }
        //打印看看
        linkedList.printList();
    }
}
