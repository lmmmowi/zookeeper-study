package com.lmmmowi.zkstudy.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/16
 * @Description:
 */
public class CreateNodeDemo implements Runnable {

    @Override
    public void run() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");
        zkClient.createPersistent("/test/node-Persistent", true);
        if (!zkClient.exists("/test/node-Ephemeral")) {
            zkClient.createEphemeral("/test/node-Ephemeral");
        }
    }
}
