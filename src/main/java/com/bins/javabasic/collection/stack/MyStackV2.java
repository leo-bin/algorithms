package com.bins.javabasic.collection.stack;

/**
 * @author leo-bin
 * @date 2020/5/14 22:47
 * @apiNote 使用链表实现一个栈
 * 思路：
 * 1.使用链表来实现栈其实有多种方式
 * 2.最简单的方式就是使用单链表+头插法的方式
 * 3.还有一种就是使用双向链表+头插法的方式
 * 4.使用头插法可能稍微复杂了一点，但是只需要用到单链表，高效又省空间
 * 5.如果使用尾插法的话，可能实现起来比较容易，但是在删除尾节点的时候需要用到双向链表，占用空间比较多
 * 6.这里是使用了第一种方式，单链表+头插法
 */
public class MyStackV2 {

    /**
     * head指针
     */
    private Node head;
    /**
     * 栈的长度
     */
    private int count;

    public MyStackV2() {
    }

    /**
     * 内部节点
     */
    public class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    /**
     * push
     */
    public int push(int item) {
        Node newNode = new Node(item);
        //创建头结点
        if (head == null) {
            head = newNode;
        } else {
            //使用尾插法插入链表
            newNode.next = head;
            head = newNode;
        }
        count++;
        return item;
    }


    /**
     * peek
     */
    public int peek() {
        if (count == 0) {
            throw new RuntimeException("栈为空！");
        }
        return head.data;
    }


    /**
     * pop
     */
    public int pop() {
        if (count == 0) {
            throw new RuntimeException("栈为空！");
        }
        int obj = peek();
        //删除头结点(head往后面移一个)
        head = head.next;
        count--;
        return obj;
    }


    /**
     * isEmpty
     */
    public boolean isEmpty() {
        return count == 0;
    }


    public static void main(String[] args) {
        MyStackV2 stack = new MyStackV2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
