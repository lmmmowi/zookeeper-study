package com.lmmmowi.zkstudy.curator;

import org.apache.curator.framework.CuratorFramework;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/20
 * @Description:
 */
public class NodeDataDemo extends CuratorDemo {

    public NodeDataDemo() {
        super(null);
    }

    @Override
    protected void run(CuratorFramework curator) throws Exception {
        curator.create().creatingParentsIfNeeded().forPath("/data/node1");
        curator.setData().forPath("/data/node1", "hello world".getBytes());
        byte[] data = curator.getData().forPath("/data/node1");
        logger.info("data: {}", new String(data));
        curator.delete().deletingChildrenIfNeeded().forPath("/data");
    }
}
