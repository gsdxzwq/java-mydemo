package com.zhaowq.designpatten.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaowq
 * @date 2016/2/1
 */
public class PeopleNewsPaper implements NewsPaper {
    private List<SubScribe> subList = new ArrayList<>();

    @Override
    public void registerSubscriber(SubScribe subScribe) {
        subList.add(subScribe);
    }

    @Override
    public void removeSubscriber(SubScribe subScribe) {
        if (subList.indexOf(subScribe) >= 0) {
            subList.remove(subScribe);
        }
    }

    @Override
    public void sendPaper() {
        for (SubScribe sub : subList) {
            sub.hasNewPaper();
        }
    }
}
