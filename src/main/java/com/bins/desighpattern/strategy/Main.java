package com.bins.desighpattern.strategy;

import com.bins.desighpattern.strategy.gooddemo.ShareUtil;

/**
 * @author leo-bin
 * @date 2020/4/27 20:59
 * @apiNote 多重if else 嵌套选择的重构案例
 */
public class Main {


    /**
     * 页面分享跳转方法
     *
     * @apiNote 案例：
     * 1.可以看到，当选择很多的时候，我们不得不写出这样的代码
     * 2.如果业务比较简单，我们这样写当前没什么问题
     * 3.但是如果一旦业务量变大，逻辑变得越来越来复杂，这样的重复代码越来越多
     * 4.最后就会导致系统的可维护性变差，代码可读性，健壮性变弱
     */
    public static void shareServiceDemo1(String option) {
        if (option.equals("微博")) {
            System.out.println("跳转到微博页面。。。");
        } else if (option.equals("QQ")) {
            System.out.println("跳转到QQ页面。。。");
        } else if (option.equals("微信")) {
            System.out.println("跳转到微信。。。");
        } else if (option.equals("朋友圈")) {
            System.out.println("跳转到朋友圈");
        }
        //.....more options....
    }


    /**
     * 通过策略模式重构的代码(一行代码NB :) )
     */
    public static void shareServiceDemo2(String option) {
        ShareUtil.shareOptions(option);
    }


    public static void main(String[] args) {
        //////////////1.方法一，通过重复if else的嵌套方法来实现分享//////////////
        String option = "QQ";
        shareServiceDemo1(option);
        //////////////2.方法二，通过策略模式来实现分享/////////////////////////
        shareServiceDemo2(option);
    }
}
