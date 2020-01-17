package com.lmmmowi.zkstudy.zkclient;

import org.I0Itec.zkclient.ZkClient;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/16
 * @Description:
 */
public class CreateSessionDemo implements Runnable {

    @Override
    public void run() {
        String zkServers = "127.0.0.1:2181";
        int sessionTimeout = 30000;
        int connectionTimeout = 5000;
        ZkClient zkClient = new ZkClient(zkServers, sessionTimeout, connectionTimeout);
        System.out.println("成功创建zookeeper会话，ZkClient将Zookeeper异步的会话创建过程封装为同步化");
    }

}
