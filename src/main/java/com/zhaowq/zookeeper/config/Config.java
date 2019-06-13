package com.zhaowq.zookeeper.config;

/**
 * @ClassName: Config
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2015年12月28日下午3:23:27
 *
 */
public interface Config {
	byte[] getConfig(String path) throws Exception;
}
