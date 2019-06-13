package com.zhaowq.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 若想得到线程处理返回值，可以使用ExecutorCompletionService
 *
 * @author zhaowq
 * @date 2018/4/13
 */
public class FutureResultTest {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 存储执行结果的List
        List<Future<String>> results = new ArrayList<>();

        // 提交10个任务
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<String> result = executorService.submit(() -> {
                int sleepTime = new Random().nextInt(1000);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "线程" + finalI + "睡了" + sleepTime + "秒";
            });
            // 将执行结果存入results中
            results.add(result);
        }

        // 获取10个任务的返回结果
        for (int i = 0; i < 10; i++) {
            // 获取包含返回结果的future对象
            Future<String> future = results.get(i);
            // 从future中取出执行结果（若尚未返回结果，则get方法被阻塞，直到结果被返回为止）
            String result = null;
            try {
                result = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }

    }
}
