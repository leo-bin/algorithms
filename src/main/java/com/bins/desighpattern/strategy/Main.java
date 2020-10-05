package com.bins.desighpattern.strategy;

import com.bins.desighpattern.strategy.gooddemo.ShareSelector;

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
        if (option.equals("WeiBo")) {
            System.out.println("正在分享到微博页面。。。");
        } else if (option.equals("QQ")) {
            System.out.println("正在分享到QQ页面。。。");
        } else if (option.equals("WeChat")) {
            System.out.println("正在分享到微信。。。");
        } else if (option.equals("Friends")) {
            System.out.println("正在分享到朋友圈");
        }
        //.....more options....
    }

    /**
     * 通过策略模式重构的代码(一行代码NB :) )
     */
    public static void shareServiceDemo2(String option) {
        ShareSelector.select(option);
    }


    public static void main(String[] args) {
        String option = "QQ";

        //////////////1.方法一，通过重复if else的嵌套方法来实现分享//////////////
        shareServiceDemo1(option);

        //////////////2.方法二，通过策略模式来实现分享/////////////////////////
        shareServiceDemo2(option);
    }
}
