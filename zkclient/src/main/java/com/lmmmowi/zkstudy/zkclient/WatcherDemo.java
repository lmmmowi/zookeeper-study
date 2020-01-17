package com.lmmmowi.zkstudy.zkclient;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/17
 * @Description:
 */
public class WatcherDemo implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");

        zkClient.subscribeStateChanges(new IZkStateListener() {
            @Override
            public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception {
                logger.info("handleStateChanged, {}", keeperState);
            }

            @Override
            public void handleNewSession() throws Exception {
                logger.info("handleNewSession");
            }

            @Override
            public void handleSessionEstablishmentError(Throwable throwable) throws Exception {
                logger.error("handleSessionEstablishmentError", throwable);
            }
        });

        // 可以对不存在的节点进行监听
        zkClient.subscribeChildChanges("/listener", (path, children) -> logger.info("subscribeChildChanges, path is {}, children are {}", path, children));
        zkClient.createPersistent("/listener");
        zkClient.createEphemeral("/listener/a");

        zkClient.subscribeDataChanges("/listener/a", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                logger.info("handleDataChange, path is {}, data is {}", s, o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                logger.info("handleDataDeleted, path is {}", s);
            }
        });
        zkClient.writeData("/listener/a", 1234);
        sleep(500);
        zkClient.writeData("/listener/a", 5678);
        sleep(500);
        zkClient.delete("/listener/a");
        sleep(500);

        zkClient.deleteRecursive("/listener");
        sleep(500);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
