package com.zhaowq.designpatten.observer;

/**
 * @author zhaowq
 * @date 2016/2/1
 */
public class Start {
    public static void main(String[] args) {
        PeopleNewsPaper paper = new PeopleNewsPaper();
        SubHuman xiaoMing = new SubHuman("小明");
        SubHuman zhaoYun = new SubHuman("赵云");
        SubHuman liuBei = new SubHuman("刘备");
        // 小明订报
        paper.registerSubscriber(xiaoMing);
        // 赵云订报
        paper.registerSubscriber(zhaoYun);
        // 刘备订报
        paper.registerSubscriber(liuBei);
        // 有新报纸了
        paper.sendPaper();
        System.out.println("---------------发完报纸了------------------");

        // 小明不想订了，取消报纸
        paper.removeSubscriber(xiaoMing);
        // 又有新报纸了 就没有小明的报纸了
        paper.sendPaper();
        System.out.println("---------------发完报纸了------------------");
    }
}
