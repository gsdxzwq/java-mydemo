package com.zhaowq.zookeeper.concurrent;

import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.zookeeper.common.PathUtils;

/**
 * @ClassName: MutexLockSynchronous
 * @Description: 基于普通排他锁的方式实现同步
 * @author zhaowq
 * @date 2015年12月28日上午10:59:01
 *
 */
public class MutexLockSynchronous implements Synchronous {
	private final ZkClientHolder zkClientHolder;

	public MutexLockSynchronous(ZkClientHolder zkClientHolder) {
		this.zkClientHolder = zkClientHolder;
	}

	public String execute(String path, SynchronousProcessor processor) {
		PathUtils.validatePath(path);
		InterProcessLock lock = new InterProcessMutex(zkClientHolder.get(), path);
		try {
			lock.acquire();
			if (null != processor)
				return processor.process();
		} catch (Exception e) {
			if (null != processor)
				processor.exceptionCaught(e);
		} finally {
			try {
				lock.release();
			} catch (Exception e) {
			}
		}
		return null;
	}
}
