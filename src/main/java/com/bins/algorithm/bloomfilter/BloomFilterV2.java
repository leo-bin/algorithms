package com.bins.algorithm.bloomfilter;

import java.util.BitSet;

/**
 * @author leo-bin
 * @date 2020/5/5 14:38
 * @apiNote 仿造布隆过滤器
 */
public class BloomFilterV2 {


    /**
     * 使用加法hash算法，所以定义了一个8个元素的质数数组
     */
    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11, 13, 17, 19};

    /**
     * 用八个不同的质数，相当于构建8个不同算法
     */
    private Hash[] hashList = new Hash[PRIMES.length];

    /**
     * 创建一个长度为10亿的比特位，256=2^8,所以下面就相当于：2^8 x 2^22 = 2^30 = 1024*1024*1024=1073741824
     */
    private BitSet bits = new BitSet(256 << 22);


    public BloomFilterV2() {
        for (int i = 0; i < PRIMES.length; i++) {
            //使用8个质数，创建八种算法
            hashList[i] = new Hash(PRIMES[i]);
        }
    }


    /**
     * 添加元素
     */
    public void add(String value) {
        for (Hash f : hashList) {
            //算出8个信息指纹，对应到2的32次方个比特位上
            bits.set(f.hash(value), true);
        }
    }


    /**
     * 判断是否在布隆过滤器中
     */
    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (Hash f : hashList) {
            //查看8个比特位上的值
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }


    /**
     * 加法hash算法
     */
    public static class Hash {
        private int prime;

        public Hash(int prime) {
            this.prime = prime;
        }

        /**
         * hash算法
         */
        public int hash(String key) {
            int hash, i;
            for (hash = key.length(), i = 0; i < key.length(); i++) {
                hash += key.charAt(i);
            }
            return (hash % prime);
        }
    }


    public static void main(String[] args) {
        int total = 1000000000;
        BloomFilterV2 bloomFilter = new BloomFilterV2();
        String userId = "5324512515";
        String userIdNotExist = "12345678910";

        System.out.println("用户id为：" + userId + "的用户是否存在：" + bloomFilter.contains(userId));
        bloomFilter.add(userId);

        //维护10亿个在线用户
        for (int i = 1; i < total; i++) {
            bloomFilter.add(String.valueOf(i));
        }

        //测试一个已经存在过的userId
        long begin = System.currentTimeMillis();
        System.out.println("用户id为：" + userId + "的用户是否存在：" + bloomFilter.contains(userId));
        long end = System.currentTimeMillis();
        System.out.println("判断5324512515是否在线使用了:" + (begin - end));

        //测试一个不存在的userId
        long begin2 = System.currentTimeMillis();
        System.out.println("用户id为：" + userIdNotExist + "的用户是否存在：" + bloomFilter.contains(userIdNotExist));
        long end2 = System.currentTimeMillis();
        System.out.println("判断用户id为" + userIdNotExist + "是否在线使用了:" + (begin2 - end2));


        //误判数量
        int falseNumber = 0;
        for (int i = total; i < total * 2; i++) {
            if (bloomFilter.contains(String.valueOf(i))) {
                falseNumber++;
            }
        }
        System.out.println("误判个数：" + falseNumber + ",误判率：" + falseNumber * 1.0 / total);
    }

}
