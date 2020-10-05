package com.bins.desighpattern.strategy.gooddemo;

/**
 * @author leo-bin
 * @date 2020/4/27 20:41
 * @apiNote 处理分享至微博的业务
 */
public class ShareWeiBo implements ShareStrategy {

    @Override
    public void share() {
        System.out.println("正在分享至微博。。。");
    }
}
