package com.bins.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author leo-bin
 * @date 2020/5/22 21:16
 * @apiNote 封装jedis工具
 */
public class JedisUtil {

    private static final String HOST = "47.100.170.169";
    private static final int PORT = 6379;
    private static final String PASS_WORD = "115118";
    private static final int MAX_IDLE = 8;
    private static final int MAX_TOTAL = 18;
    private static final int TIMEOUT = 6000;

    private static JedisPool pool;

    //初始化redis连接池
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMaxTotal(MAX_TOTAL);
        pool = new JedisPool(config, HOST, PORT, TIMEOUT, PASS_WORD);
    }

    /**
     * 获取一个redis连接示例
     *
     * @return jedis
     */
    public static Jedis getInstance() {
        return pool.getResource();
    }

}
