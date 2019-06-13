package com.zhaowq.zookeeper.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

/**
 * @ClassName: ZooKeeperConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2015年12月28日下午3:24:00
 *
 */
public class ZooKeeperConfig implements Config {
	public byte[] getConfig(String path) throws Exception {
		CuratorFramework client = ZooKeeperFactory.get();
		if (!exists(client, path)) {
			throw new RuntimeException("Path " + path + " does not exists.");
		}
		return client.getData().forPath(path);
	}

	private boolean exists(CuratorFramework client, String path) throws Exception {
		Stat stat = client.checkExists().forPath(path);
		return !(stat == null);
	}
}
