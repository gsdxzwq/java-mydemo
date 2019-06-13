package com.zhaowq.designpatten.observer;

/**
 * @author zhaowq
 * @date 2016/2/1
 */
public class SubHuman implements SubScribe {
    /**
     * 订阅者的名字
     */
    private String pName;

    SubHuman(String pName) {
        this.pName = pName;
    }

    /**
     * 告诉订阅者有新报纸了
     */
    @Override
    public void hasNewPaper() {
        System.out.println(pName + "!! 有新的报纸了，请查收！");
    }
}
