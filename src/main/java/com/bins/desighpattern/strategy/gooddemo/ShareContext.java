package com.bins.desighpattern.strategy.gooddemo;


/**
 * @author leo-bin
 * @date 2020/4/27 20:51
 * @apiNote 分享策略的上下文，持有某个具体的策略
 */
public class ShareContext {

    /**
     * 具体的策略名
     */
    private String type;
    /**
     * 具体分享策略实例
     */
    private ShareStrategy shareStrategy;

    public ShareContext(String type, ShareStrategy shareStrategy) {
        this.type = type;
        this.shareStrategy = shareStrategy;
    }

    public ShareStrategy getShareStrategy() {
        return this.shareStrategy;
    }

    /**
     * 分享策略的匹配
     *
     * @param type 分享类型
     * @return 是否匹配成功
     */
    public boolean options(String type) {
        return this.type.equals(type);
    }

    public void doShare() {
        shareStrategy.share();
    }
}
