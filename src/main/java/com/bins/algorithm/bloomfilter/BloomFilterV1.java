package com.bins.algorithm.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author leo-bin
 * @date 2020/5/5 14:35
 * @apiNote 谷歌guava版布隆过滤器
 */
public class BloomFilterV1 {

    /**
     * 设置期望插入过滤器中的数据总量
     */
    private static int total = 10000000;

    /**
     * 真实测试数据总量
     */
    private static int test = 10000000;

    /**
     * 初始化并创建一个过滤器
     */
//    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);


    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total, 0.001);


    public static void main(String[] args) {
        // 初始化1000000条数据到过滤器中
        for (int i = 0; i < test; i++) {
            bf.put(i);
        }

        // 匹配已在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < test; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("有坏人逃脱了~~~");
            }
        }

        // 匹配不在过滤器中的10000个值，有多少匹配出来
        int count = 0;
        for (int i = test; i < test * 2; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误判的数量：" + count + "，误判率：" + count * 1.0 / test);
    }

}
