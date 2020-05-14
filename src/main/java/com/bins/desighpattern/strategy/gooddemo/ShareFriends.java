package com.bins.desighpattern.strategy.gooddemo;

/**
 * @author leo-bin
 * @date 2020/4/27 20:46
 * @apiNote 处理分享至朋友圈的业务
 */
public class ShareFriends implements ShareStrategy {

    @Override
    public void share(String option) {
        System.out.println("分享至朋友圈。。。");
    }
}
