package com.lmmmowi.zkstudy.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/17
 * @Description:
 */
public class NodeDataDemo implements Runnable {

    @Override
    public void run() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");
        zkClient.createPersistent("/data");
        zkClient.createEphemeral("/data/node1");
        zkClient.writeData("/data/node1", "hello world");
        String string = zkClient.readData("/data/node1");
        System.out.println(string);
        zkClient.deleteRecursive("/data");
    }
}
