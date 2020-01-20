package com.lmmmowi.zkstudy.curator;

import org.apache.curator.framework.CuratorFramework;

import java.util.List;

/**
 * @Author: lmmmowi
 * @Date: 2020/1/20
 * @Description:
 */
public class GetChildrenDemo extends CuratorDemo {

    public GetChildrenDemo() {
        super("test");
    }

    @Override
    protected void run(CuratorFramework curator) throws Exception {
        List<String> nodes = curator.getChildren().forPath("/");
        nodes.forEach(o -> logger.info("child: {}", o));
    }
}
