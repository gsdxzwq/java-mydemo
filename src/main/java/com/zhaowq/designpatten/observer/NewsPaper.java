package com.zhaowq.designpatten.observer;

/**
 * @author zhaowq
 * @date 2016/2/1
 */
public interface NewsPaper {
    /**
     * 添加订阅者
     */
    void registerSubscriber(SubScribe subScribe);

    /**
     * 取消订阅
     */
    void removeSubscriber(SubScribe subScribe);

    /**
     * 发送报纸
     */
    void sendPaper();
}
