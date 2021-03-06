package com.bins.bishi.spring2020.alibaba;

/**
 * @author leo-bin
 * @date 2020/4/15 14:50
 * @apiNote
 */
public class Main2 {

    /**
     * 第2题：
     * 1.有N个怪兽，M个弓箭，每个怪兽有生命值，每个弓箭有杀伤力和价值
     * 2.每个怪兽只能用一支弓箭攻击
     * 3.弓箭杀伤>=怪兽生命时可消灭怪兽
     * 4.求使用弓箭的最小价值
     * 5.如无法消灭，返回-1
     *
     * @apiNote 思路：
     * 1.对怪兽生命从大到小排序
     * 2.对弓箭按攻击力从大到小排序
     * 3.建立一个优先队列，按照价值从小到大
     * 4.之后按照顺序对每个怪兽计算:
     * 5.找出所有攻击力大于等于其生命值的弓箭，将其加入优先队列
     * 6.若此时队列空，证明没有可以消灭该怪兽的弓箭了，返回-1
     * 7.否则将优先队列队头出队，记录其价值。
     * 8.最后返回总价值即可。
     * 9.时间复杂度O(mlogm)
     */

    public static void main(String[] args) {

    }
}
