package com.zhaowq.multithreading;

/**
 * @author zhaowq
 * @date 2015/12/29
 */
public class ThreadPoolTask implements Runnable {
    private Object attachData;

    ThreadPoolTask(Object tasks) {
        this.attachData = tasks;
    }

    @Override
    public void run() {
        System.out.println("开始执行任务：" + attachData);
        attachData = null;
    }

    public Object getTask() {
        return this.attachData;
    }
}
