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
public class CreateSessionDemo implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run() {
        String zkServers = "127.0.0.1:2181";
        int sessionTimeout = 30000;
        int connectionTimeout = 5000;
        CuratorFramework curator = CuratorFrameworkFactory.builder()
                .connectString(zkServers)
                .sessionTimeoutMs(sessionTimeout)
                .connectionTimeoutMs(connectionTimeout)
                .retryPolicy(new RetryOneTime(100))
                .build();
        curator.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            logger.error("error", e);
        }
    }
}
