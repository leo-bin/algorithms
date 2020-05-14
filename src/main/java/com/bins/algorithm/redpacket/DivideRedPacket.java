package com.bins.algorithm.redpacket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leo-bin
 * @date 2020/5/14 20:22
 * @apiNote 分红包问题
 */
public class DivideRedPacket {


    /**
     * 题目描述：
     * 1.分红包算法的简单实现
     * 2.现在有个业务场景需要在线发放红包的功能，类似于微信红包
     * 3.例如一个人在群里发了一个100块钱的红包，群里有10个人同时抢红包
     * 4.每个人抢到的金额完全随机。
     * 5.要求所有人抢到的金额总数等于红包金额，不能多也不能少
     * 6.每个人抢到的红包金额不得低于0.01元
     * 7.要保证红包拆分的金额尽可能的分布均衡，不能出现两极分化严重的情况
     *
     * @apiNote 思路：
     * 1.我们首先就能想到这道题本质上就是一个分配问题！
     * 2.那我们如何分配才能保证绝对的公平呢？一个解决方案就是随机数！
     * 3.在Java中，jdk为我们提供了一个很方便的随机数生成api，那就是Random
     * 4.Random.nextInt(a)表示返回一个从0到a的随机int数
     * 5.也就是说，我们只要确定这个a，那么红包的金额也就迎刃而解了！
     * 6.但是我们如何确定这个a呢？一种非常直白的做法就是，a=[0.01，剩余金额-0.01]
     * 7.也就是说，假设红包金额是100，5个人抢，第一个人的随机范围就是：[0.01,99.99]
     * 8.他要从这个范围里面随机分配一个数字，假设是20，那么第二个人的随机范围就是：[0.01,79.99]
     * 9.依次类推。。。。。。
     * 10.乍一看，好像没啥问题，但是你稍微思考一下你就会发现，这个算法非常的不公平！
     * 11.因为越到后面的人，他获取金额的随机范围会越来越小！反而是先抢的人，抢到大额红包的几率要大！
     * 12.然后我们可以分析一下就知道，这个算法的缺点就是，他每一次的随机范围是递减的！
     * 13.也就是说每一个人的随机分配范围是不一样的！
     * 14.基于这一点，我们只要解决，每一次分配的随机范围的平均值是一样的就行！
     * 15.我们可以采用一种叫做二倍均值的方式解决这个问题！
     * 16.经过改良之后我们的随机范围公式等于：[0.01,m/n*2-0.01](其中m是剩余的金额，n是剩余的人数)
     * 17.还是之前的那个用例，m初始值=100，n=5
     * 18.第一个人的随机范围就是：[0.01,100/5*2-0.01],那就是，[0.01,49.99],假设他抢了20
     * 19.那么第二个人的随机范围就是：[0.01,80/4*2-0.01],那就是，[0.01,39.99],假设他也抢了20
     * 20.那么第三个人就是：[0.01,60/3*2-0.01],就是，[0.01,39.99],假设他也抢了20
     * 21.以此类推。。。。。你会发现，每一个人能够抢到的金额的平均值都是20！
     * 22.因为涉及到金钱，所以这里一般都是使用double作为数据类型，然后我们这里保留2位小数
     */
    public static List<Double> divideRedPacket(Double totalMoney, Integer totalPeople) {
        List<Double> moneyList = new ArrayList<>();
        double restMoney = totalMoney;
        int restPeople = totalPeople;
        //只算前面total-1个人，最后一个人不算
        for (int i = 0; i < totalPeople - 1; i++) {
            //[0.01,m/n*2-0.01]
            double currentMoney = getRandomMoney(restMoney, restPeople, 2);
            restMoney -= currentMoney;
            restPeople--;
            moneyList.add(currentMoney);
        }
        //最后一人就不用算随机数了，直接将剩下的钱都给他就行
        moneyList.add(getDoubleByScale(2, restMoney));
        return moneyList;
    }


    /**
     * 获取某个范围内的随机double值
     *
     * @param restMoney  剩余的钱
     * @param restPeople 剩余的人数
     * @param scale      保留精度
     * @return double
     * @apiNote 思路：
     * 1.如果要生成[start,end) 的随机数
     * 2.可以这么写：int random = start + ( Math.Random() * (end - start ))
     */
    private static double getRandomMoney(double restMoney, int restPeople, int scale) {
        double random = 0.01 + Math.random() * (restMoney * 1.0 / restPeople * 2 - 0.01);
        return getDoubleByScale(scale, random);
    }


    /**
     * 根据精度返回double值
     *
     * @apiNote 思路:
     * 1.但凡是涉及到金钱一定会保留小数点
     * 2.这里我们使用BigDecimal对象来实现
     */
    private static double getDoubleByScale(int scale, double value) {
        BigDecimal bigDecimal = new BigDecimal(Double.toString(value));
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static void main(String[] args) {
        double money = 100.0;
        int people = 10;
        List<Double> result = divideRedPacket(money, people);
        if (result != null && result.size() > 0) {
            double sum = 0;
            for (int i = 0; i < result.size(); i++) {
                System.out.println("第" + (i + 1) + "个人抢到了：" + result.get(i) + "元");
                sum += result.get(i);
            }
            System.out.println("红包总金额是：" + sum + ",共有" + people + "个人抢");
        }
    }
}
