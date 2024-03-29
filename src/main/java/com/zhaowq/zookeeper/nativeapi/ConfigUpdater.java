package com.zhaowq.zookeeper.nativeapi;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ConfigUpdater
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2016年1月12日下午2:22:11
 *
 */
public class ConfigUpdater {
	public static final String PATH = "/cfg/properties";
	  
	  private ActiveKeyValueStore store;
	  private Random random = new Random();
	  
	  public ConfigUpdater(String hosts) throws IOException, InterruptedException {
	    store = new ActiveKeyValueStore();
	    store.connect(hosts);
	  }
	  
	  public void run() throws InterruptedException, KeeperException {
	    while (true) {
	      String value = random.nextInt(100) + "";
	      store.write(PATH, value);
	      System.out.printf("Set %s to %s\n", PATH, value);
	      TimeUnit.SECONDS.sleep(random.nextInt(10));
	    }
	  }
	  
	  public static void main(String[] args) throws Exception {
	    ConfigUpdater configUpdater = new ConfigUpdater("localhost");
	    configUpdater.run();
	  }
}
