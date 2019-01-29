package com.geekluxun.cloudcollectionmonitor;

import com.dianping.cat.configuration.ClientConfigProvider;
import com.dianping.cat.configuration.client.entity.ClientConfig;
import com.dianping.cat.configuration.client.entity.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-29 15:10
 * @Description:
 * @Other:
 */
public class DemoClientConfigProvider implements ClientConfigProvider {

    @Override
    public ClientConfig getClientConfig() {
        List<Server> servers = new ArrayList<Server>();
        servers.add(new Server("116.62.63.81"));
        String domain = "cat";

        ClientConfig config = new ClientConfig();
        config.setServers(servers);
        config.setDomain(domain);
        return config;
    }
}