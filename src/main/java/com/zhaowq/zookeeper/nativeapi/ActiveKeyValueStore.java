package com.zhaowq.zookeeper.nativeapi;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;

/**
 * @ClassName: ActiveKeyValueStore
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2016年1月12日下午2:03:03
 *
 */
public class ActiveKeyValueStore extends ConnectionWatcher {
    private static final Charset CHARSET = Charset.forName("UTF-8");

    public void write(String path, String value) throws InterruptedException, KeeperException {
        Stat stat = zk.exists(path, false);
        if (stat == null) {
            zk.create(path, value.getBytes(CHARSET), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } else {
            zk.setData(path, value.getBytes(CHARSET), -1);
        }
    }

    public String read(String path, Watcher watcher) throws InterruptedException, KeeperException {
        byte[] data = zk.getData(path, watcher, null/* stat */);
        return new String(data, CHARSET);
    }
}
