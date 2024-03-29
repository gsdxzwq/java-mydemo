package com.zhaowq.zookeeper.nativeapi;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;

import java.io.IOException;

/**
 * @ClassName: ConfigWatcher
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2016年1月12日下午2:28:01
 *
 */
public class ConfigWatcher implements Watcher {
	private ActiveKeyValueStore store;

	public ConfigWatcher(String hosts) throws IOException, InterruptedException {
		store = new ActiveKeyValueStore();
		store.connect(hosts);
	}

	public void displayConfig() throws InterruptedException, KeeperException {
		String value = store.read(ConfigUpdater.PATH, this);
		System.out.printf("Read %s as %s\n", ConfigUpdater.PATH, value);
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDataChanged) {
			try {
				displayConfig();
			} catch (InterruptedException e) {
				System.err.println("Interrupted. Exiting.");
				Thread.currentThread().interrupt();
			} catch (KeeperException e) {
				System.err.printf("KeeperException: %s. Exiting.\n", e);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ConfigWatcher configWatcher = new ConfigWatcher("localhost");
		configWatcher.displayConfig();

		// stay alive until process is killed or thread is interrupted
		Thread.sleep(Long.MAX_VALUE);
	}
}
