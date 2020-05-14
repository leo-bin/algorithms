package com.bins.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author leo-bin
 * @date 2020/2/23 19:50
 * @apiNote Java手写LRU算法：
 * 1.最朴素的思想就是用数组+时间戳的方式，不过这样做效率较低
 * 2.因此，我们可以用双向链表（LinkedList）+哈希表（HashMap）实现（链表用来表示位置，哈希表用来存储和查找）
 * 3.这里利用Java中现成的数据结构LinkedHashMap来实现一个简单的LRU算法
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * 初始缓存大小
     */
    private final int CACHE_SIZE;

    /**
     * 初始化缓存，并设置大小
     *
     * @param cacheSize 缓存大小
     */
    public LRUCache(int cacheSize) {
        //初始化一个LinkedHashMap，true表示按照访问顺序来进行排序，最近访问的数据放在尾部，最老访问的放在头部
        super((int) Math.ceil((cacheSize / 0.75) + 1), 0.75f, true);
        this.CACHE_SIZE = cacheSize;
    }

    /**
     * 是否移除最久没被访问的那个节点
     *
     * @return 是否满足删除条件
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //判断现在map中的数量是否达到了指定的缓存数
        //在调用put方法的时候，会调用这个方法，如果达到了缓存的大小，删掉最长时间没被访问的entry
        return size() > CACHE_SIZE;
    }
}
