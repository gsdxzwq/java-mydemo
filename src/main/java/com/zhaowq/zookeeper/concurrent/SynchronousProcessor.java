package com.zhaowq.zookeeper.concurrent;

/**
 * @ClassName: SynchronousProcessor
 * @Description: 同步业务处理器
 * @author zhaowq
 * @date 2015年12月28日上午10:59:59
 *
 */
public interface SynchronousProcessor {
	/**
     * 处理具体的业务
     * 
     * @return
     */
    String process();
     
    /**
     * 异常捕获
     * 
     * @param throwable
     */
    void exceptionCaught(Throwable throwable);
}
