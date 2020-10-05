package com.bins.desighpattern.strategy.gooddemo;

/**
 * @author leo-bin
 * @date 2020/4/27 20:43
 * @apiNote 处理分享至QQ的业务
 */
public class ShareQQ implements ShareStrategy {

    @Override
    public void share() {
        System.out.println("正在分享至QQ。。。");
    }
}
