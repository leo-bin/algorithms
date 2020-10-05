package com.bins.desighpattern.strategy.gooddemo;

/**
 * @author leo-bin
 * @date 2020/4/27 20:44
 * @apiNote 处理分享至微信的业务
 */
public class ShareWeChat implements ShareStrategy {

    @Override
    public void share() {
        System.out.println("正在分享至微信。。。");
    }
}
