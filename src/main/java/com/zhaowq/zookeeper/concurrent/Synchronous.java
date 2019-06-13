package com.zhaowq.zookeeper.concurrent;

/**
 * @ClassName: Synchronous
 * @Description: 同步，支持分布式
 * @author zhaowq
 * @date 2015年12月28日上午10:55:43
 *
 */
public interface Synchronous {
	/**
	 * 同步执行，根据path标识来区分同步工作。不同的path将不会同步进行。
	 * 
	 * @param处理结果类型
	 * @param path
	 *            任务节点 e.g. "/project/synchronous/0000001"      
	 * @param processor
	 *            业务处理器      
	 * @return 处理结果      
	 */
	String execute(String path, SynchronousProcessor processor);
}
