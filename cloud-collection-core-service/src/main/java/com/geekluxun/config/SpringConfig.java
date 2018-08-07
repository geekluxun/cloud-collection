package com.geekluxun.config;

import com.google.common.collect.Lists;
import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.ShardingStrategyConfiguration;
import io.shardingsphere.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.core.util.DataSourceUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Date: 2018-07-27 17:45
 * @Description:
 * @Others:
 */

@Configuration
@ImportResource(locations = {
        "classpath:spring/dubbo-client.xml",
        "classpath:spring/dubbo-service.xml"
})
public class SpringConfig {

    @Value("${sharding.jdbc.datasource.master0.url}")
    String master0Url;

    @Value("${sharding.jdbc.datasource.master1.url}")
    String master1Url;


    @Value("${sharding.jdbc.datasource.master0slave0.url}")
    String master0Slave0Url;

    @Value("${sharding.jdbc.datasource.master0slave1.url}")
    String master0Slave1Url;

    @Value("${sharding.jdbc.datasource.master1slave0.url}")
    String master1Slave0Url;

    @Value("${sharding.jdbc.datasource.master1slave1.url}")
    String master1Slave1Url;

    @Value("${sharding.jdbc.datasource.master1slave0.driver-class-name}")
    String driverClassName;

    @Value("${sharding.jdbc.datasource.master1slave0.username}")
    String userName;

    @Value("${sharding.jdbc.datasource.master1slave0.password}")
    String password;


    @Bean
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
        shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");


        //shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", ModuleShardingTableAlgorithm.class.getName()));
        //shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id", ModuloShardingTableAlgorithm.class.getName()));
        shardingRuleConfig.setMasterSlaveRuleConfigs(getMasterSlaveRuleConfigurations());
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new HashMap<String, Object>(), new Properties());
    }

    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("t_order");
        result.setActualDataNodes("ds${0..1}.t_order${[0, 1]}");
        result.setKeyGeneratorColumnName("id");
        return result;
    }

    TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("t_order_item");
        result.setActualDataNodes("ds${0..1}.t_order_item${[0, 1]}");
        return result;
    }

    List<MasterSlaveRuleConfiguration> getMasterSlaveRuleConfigurations() {
        MasterSlaveRuleConfiguration masterSlaveRuleConfig1 = new MasterSlaveRuleConfiguration("ds0", "ds0",Arrays.asList("ds0_slave0", "ds0_slave1"));
//        masterSlaveRuleConfig1.setName("ds0");
//        masterSlaveRuleConfig1.setMasterDataSourceName("ds_master0");
//        masterSlaveRuleConfig1.setSlaveDataSourceNames(Arrays.asList("ds_master0_slave0", "ds_master0_slave1"));

        MasterSlaveRuleConfiguration masterSlaveRuleConfig2 = new MasterSlaveRuleConfiguration("ds1", "ds1",Arrays.asList("ds1_slave0", "ds1_slave1"));
//        masterSlaveRuleConfig2.setName("ds1");
//        masterSlaveRuleConfig2.setMasterDataSourceName("ds_master1");
//        masterSlaveRuleConfig2.setSlaveDataSourceNames(Arrays.asList("ds_master1_slave0", "ds_master1_slave1"));
        return Lists.newArrayList(masterSlaveRuleConfig1, masterSlaveRuleConfig2);
    }


    Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(master0Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        result.put("ds0", dataSource);
        dataSource.setUrl(master0Slave0Url);
        result.put("ds0_slave0", dataSource);

        dataSource.setUrl(master0Slave1Url);
        result.put("ds0_slave1", dataSource);

        dataSource.setUrl(master1Url);
        result.put("ds1", dataSource);

        dataSource.setUrl(master1Slave0Url);
        result.put("ds1_slave0", dataSource);

        dataSource.setUrl(master1Slave1Url);
        result.put("ds1_slave1", dataSource);

        return result;
    }
}
