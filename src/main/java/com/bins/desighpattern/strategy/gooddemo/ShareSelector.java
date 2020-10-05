package com.bins.desighpattern.strategy.gooddemo;

import java.util.HashMap;

/**
 * @author leo-bin
 * @date 2020/4/27 20:27
 * @apiNote 通过策略模式重构之后的代码
 */
public class ShareSelector {

    /**
     * 存放所有策略的上下文
     */
    private static HashMap<String, ShareContext> shareContexts = new HashMap<>(16);


    //通过静态代码块提前将所需要的分享策略加载完毕
    static {
        //1.加载分享朋友圈策略
        shareContexts.put("Friends", new ShareContext("Friends", new ShareFriends()));
        //2.加载分享QQ策略
        shareContexts.put("QQ", new ShareContext("QQ", new ShareQQ()));
        //3.加载分享微博策略
        shareContexts.put("WeiBo", new ShareContext("WeiBo", new ShareWeiBo()));
        //4.加载分享微信策略
        shareContexts.put("WeChat", new ShareContext("WeChat", new ShareWeChat()));
        //....load other strategy...
    }


    /**
     * 分享策略
     *
     * @param shareType 分享类型
     */
    public static void select(String shareType) {
        ShareContext shareContext = shareContexts.get(shareType);
        if (shareContext != null) {
            shareContext.doShare();
        } else {
            System.out.println("暂时没有此分享类型：" + shareType);
        }
    }

}
