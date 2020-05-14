package com.bins.algorithm.lru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leo-bin
 * @date 2020/2/23 21:04
 * @apiNote LRU测试
 */
public class LRUTest {

    private static final Logger log = LoggerFactory.getLogger(LRUTest.class);

    /**
     * 初始化一个容量大小为10的LRU缓存
     */
    private static LRUCache<String, Integer> lruCache = new LRUCache<>(10);

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) {
        //往缓存中加10个数，加入之后，缓存现在已经满了
        for (int i = 0; i < 8; i++) {
            lruCache.put("k" + i, i);
        }
        //先看看现在缓存中的情况
        log.info("all cache:{}", lruCache);

        //先访问一次k3
        lruCache.get("k3");
        log.info("get k3之后：{}", lruCache);

        //在访问一次k4
        lruCache.get("k4");
        log.info("get k4之后：{}", lruCache);

        //往容量已经满了的缓存中再加一个数k10,看看谁被淘汰了
        lruCache.put("k10", 10);
        log.info("put k10之后：{}", lruCache);
    }
}
