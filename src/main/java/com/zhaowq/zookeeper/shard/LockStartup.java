package com.zhaowq.zookeeper.shard;

import com.zhaowq.zookeeper.config.ZooKeeperFactory;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: LockStartup
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2015年12月28日下午3:12:32
 *
 */
public class LockStartup {
	public static void main(String[] args) throws Exception {
        // ZooKeeperFactory在上一篇文章《ZooKeeper学习笔记—配置管理》中有
        CuratorFramework client = ZooKeeperFactory.get();
        final InterProcessSemaphoreMutex processSemaphoreMutex = new InterProcessSemaphoreMutex(client, "/lock");
        printProcess(processSemaphoreMutex);
         
        System.out.println("Starting get lock...");
        boolean flag = processSemaphoreMutex.acquire(12, TimeUnit.SECONDS);
        System.out.println(flag ? "Getting lock successful." : "Getting failed!");
         
        printProcess(processSemaphoreMutex);
         
        Thread.sleep(20 * 1000);
         
        if (processSemaphoreMutex.isAcquiredInThisProcess()) {
            processSemaphoreMutex.release();
        }
        printProcess(processSemaphoreMutex);
        client.close();
    }
     
    private static void printProcess(final InterProcessSemaphoreMutex processSemaphoreMutex) {
        // 在本进程中锁是否激活（是否正在执行）
        System.out.println("isAcquiredInThisProcess: " + processSemaphoreMutex.isAcquiredInThisProcess());
    }
}
