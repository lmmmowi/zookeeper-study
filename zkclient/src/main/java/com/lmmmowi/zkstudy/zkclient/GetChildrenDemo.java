package com.lmmmowi.zkstudy.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/16
 * @Description:
 */
public class GetChildrenDemo implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run() {
        ZkClient zkClient = new ZkClient("127.0.0.1:2181");
        List<String> nodes = zkClient.getChildren("/test");
        nodes.forEach(o -> logger.info("child: {}", o));
    }
}
