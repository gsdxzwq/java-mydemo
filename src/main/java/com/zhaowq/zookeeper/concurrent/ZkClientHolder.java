package com.zhaowq.zookeeper.concurrent;

import com.google.common.base.Preconditions;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @ClassName: ZkClientHolder
 * @Description: ZooKeeper client holder
 * @author zhaowq
 * @date 2015年12月28日下午1:56:46
 *
 */
public class ZkClientHolder extends BaseLifeCycleSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(ZkClientHolder.class);

	public static final int MAX_RETRIES = 3;
	public static final int BASE_SLEEP_TIMEMS = 3000;

	private CuratorFramework zkClient;

	private final String connectString;
	private final int sessionTimeout;

	public ZkClientHolder(String connectString, int sessionTimeout) {
		Preconditions.checkArgument(!StringUtils.isEmpty(connectString), "connectString cannot be blank");
		Preconditions.checkArgument(sessionTimeout >= 10000, "sessionTimeout must be greater than 10000");
		this.connectString = connectString;
		this.sessionTimeout = sessionTimeout;
	}

	public CuratorFramework get() {
		return zkClient;
	}

	@Override
	protected void doInit() {
		zkClient = CuratorFrameworkFactory.builder().sessionTimeoutMs(sessionTimeout).connectString(connectString)
				.retryPolicy(new ExponentialBackoffRetry(BASE_SLEEP_TIMEMS, MAX_RETRIES)).build();
		zkClient.start();
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Connected to ZooKepper server: {}", connectString);
		}
	}

	@Override
	protected void doDestroy() {
		if (null != zkClient)
			zkClient.close();
	}
}
