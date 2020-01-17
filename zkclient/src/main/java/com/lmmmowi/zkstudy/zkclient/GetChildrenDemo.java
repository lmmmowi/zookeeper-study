package com.lmmmowi.zkstudy.zkclient;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/16
 * @Description:
 */
public class GetChildrenDemo implements Runnable {

    @Override
    public void run() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");
        List<String> nodes = zkClient.getChildren("/test");
        nodes.forEach(System.out::println);
    }
}
