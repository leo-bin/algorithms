package com.bins.algorithm.lru;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/4/7 19:44
 * @apiNote LRU缓存
 * HashMap+双链表+synchronized实现(线程安全)
 */
public class LRUCacheV2 {

    /**
     * 缓存容量
     */
    private final int cacheSize;
    private HashMap<String, Node> map;
    private Node head;
    private Node tail;

    public LRUCacheV2(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>(16);
    }

    /**
     * 内部节点类
     */
    public class Node {
        private String key;
        private volatile String value;
        private Node pre;
        private Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    /**
     * get操作
     * 时间复杂度：O(1)
     */
    public String get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return null;
        } else {
            refreshNode(node);
            return node.value;
        }
    }


    /**
     * put操作
     * 时间复杂度：O(1)
     */
    public void put(String key, String value) {
        Node node = map.get(key);
        synchronized (this) {
            if (node == null) {
                //缓存已满，需要删除最近最少使用的节点，其实就是头结点
                if (map.size() >= cacheSize) {
                    Node oldNode = removeNode(head);
                    map.remove(oldNode.key);
                }
                //没满或者删掉之后，放map中
                node = new Node(key, value);
                map.put(key, node);
                addNode(node);
            }
            //node已经存在，修改访问频率，并修改map中的value
            else {
                node.value = value;
                map.put(key, node);
                refreshNode(node);
            }
        }
    }


    /**
     * 刷新当前的链表
     */
    private void refreshNode(Node node) {
        if (node == tail) {
            return;
        }
        if (node != null) {
            removeNode(node);
            addNode(node);
        }
    }

    /**
     * 往链表尾部增加一个节点
     */
    private void addNode(Node node) {
        //1.head为空，那就将head指向node
        if (head == null) {
            head = node;
        }
        //2.tail不为空说明链表中有元素了，改变指向
        if (tail != null) {
            tail.next = node;
            node.pre = tail;
            node.next = null;
        }
        //3.tail无论如何都要先指向node
        tail = node;
    }

    /**
     * 随机删除链表中的一个节点
     */
    private Node removeNode(Node node) {
        //鲁棒
        if (node == null) {
            return node;
        }
        //1.要删除的节点是唯一节点
        if (node == head && node == tail) {
            head = null;
            tail = null;
        }
        //2.要删除的节点是head节点
        else if (node == head) {
            head = node.next;
            node.next.pre = null;
            node.next = null;
        }
        //3.要删除的节点是tail节点
        else if (node == tail) {
            tail = node.pre;
            node.pre.next = null;
            node.pre = null;
        }
        //4.要删除的节点是中间节点
        else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
        }
        return node;
    }


    public static void main(String[] args) {
        LRUCacheV2 lruCache = new LRUCacheV2(4);
        //初始化缓存，加四个元素进去
        lruCache.put("1", "User1");
        lruCache.put("2", "User2");
        lruCache.put("3", "User3");
        lruCache.put("4", "User4");

        //get一下其中一个元素User1
        System.out.println(lruCache.get("1"));

        //再加一个元素，加入之后User2应该被删掉了
        lruCache.put("5", "User5");

        //验证下User2是否被删掉了
        System.out.println("User2=" + lruCache.get("2"));
    }
}
