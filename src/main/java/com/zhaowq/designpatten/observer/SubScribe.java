package com.zhaowq.designpatten.observer;

/**
 * @author zhaowq
 * @date 2016/2/1
 *
 */
public interface SubScribe {
    /** 有新的报纸了就会被执行通知 */
    void hasNewPaper();
}
