package com.zhaowq.zookeeper.concurrent;

/**
 * @ClassName: BaseLifeCycleSupport
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2015年12月28日下午2:12:29
 *
 */
public abstract class BaseLifeCycleSupport {

	protected abstract void doInit();

	protected abstract void doDestroy();

}
