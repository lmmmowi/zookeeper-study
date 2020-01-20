package com.lmmmowi.zkstudy.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/20
 * @Description:
 */
public abstract class CuratorDemo implements Runnable {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private String namespace;

    public CuratorDemo(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public void run() {
        String zkServers = "127.0.0.1:2181";
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString(zkServers)
                .retryPolicy(new RetryOneTime(100))
                .namespace(namespace)
                .build();

        try {
            curator.start();
            this.run(curator);
        } catch (Exception e) {
            logger.error("error", e);
        }
    }

    protected abstract void run(CuratorFramework curator) throws Exception;
}
