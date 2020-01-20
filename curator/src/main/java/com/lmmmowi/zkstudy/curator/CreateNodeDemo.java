package com.lmmmowi.zkstudy.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/20
 * @Description:
 */
public class CreateNodeDemo extends CuratorDemo {

    public CreateNodeDemo() {
        super("test");
    }

    @Override
    protected void run(CuratorFramework curator) throws Exception {
        Stat stat = curator.checkExists().forPath("/node-Ephemeral");
        if (stat == null) {
            curator.create()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/node-Ephemeral");
        }
    }
}
