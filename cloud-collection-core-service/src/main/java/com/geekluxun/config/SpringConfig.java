package com.geekluxun.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.geekluxun.dao.TOrderItemMapper;
import com.geekluxun.dao.TOrderMapper;
import com.google.common.collect.Lists;
import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.core.jdbc.core.datasource.ShardingDataSource;
import io.shardingsphere.transaction.api.SoftTransactionManager;
import io.shardingsphere.transaction.api.config.NestedBestEffortsDeliveryJobConfiguration;
import io.shardingsphere.transaction.api.config.SoftTransactionConfiguration;
import io.shardingsphere.transaction.bed.BEDSoftTransaction;
import io.shardingsphere.transaction.constants.SoftTransactionType;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
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

//    DruidDataSource dataSource;
    DataSource myDataSource;
    
    @Bean
    DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTableRuleConfigs().add(getOrderItemTableRuleConfiguration());
        // ??
        shardingRuleConfig.getBindingTableGroups().add("t_order, t_order_item");
        // 不要用主从库功能，暂时有问题！！！
        //shardingRuleConfig.setMasterSlaveRuleConfigs(getMasterSlaveRuleConfigurations());
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "ds${id % 2}"));
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new HashMap<String, Object>(), new Properties());
    }

    /**
     * 订单表分库分表
     *
     * @return
     */
    TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("t_order");
        result.setActualDataNodes("ds${0..1}.t_order${[0, 1]}");
        // 分表策略 按照id
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "t_order${id % 2}"));
        // 分库策略
        result.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "ds${id % 2}"));
        return result;
    }

    /**
     * 订单明细表分库分表
     * @return
     */
    TableRuleConfiguration getOrderItemTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration();
        result.setLogicTable("t_order_item");
        result.setActualDataNodes("ds${0..1}.t_order_item${[0, 1]}");
        // 分表策略 按照order_id
        result.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_item${order_id % 2}"));
        // 分库策略
        result.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "ds${order_id % 2}"));
        return result;
    }

    List<MasterSlaveRuleConfiguration> getMasterSlaveRuleConfigurations() {
        MasterSlaveRuleConfiguration masterSlaveRuleConfig1 = new MasterSlaveRuleConfiguration("ds0", "ds0",Arrays.asList("ds0_slave0", "ds0_slave1"));
        MasterSlaveRuleConfiguration masterSlaveRuleConfig2 = new MasterSlaveRuleConfiguration("ds1", "ds1",Arrays.asList("ds1_slave0", "ds1_slave1"));
        return Lists.newArrayList(masterSlaveRuleConfig1, masterSlaveRuleConfig2);
    }


    /**
     *  所有的数据源
     * @return
     */
    Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(master0Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        result.put("ds0", dataSource);
        myDataSource = dataSource;

        dataSource = new BasicDataSource();
        dataSource.setUrl(master0Slave0Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        result.put("ds0_slave0", dataSource);

        dataSource = new BasicDataSource();
        dataSource.setUrl(master0Slave1Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        result.put("ds0_slave1", dataSource);

        dataSource = new BasicDataSource();
        dataSource.setUrl(master1Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        result.put("ds1", dataSource);

        dataSource = new BasicDataSource();
        dataSource.setUrl(master1Slave0Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        result.put("ds1_slave0", dataSource);

        dataSource = new BasicDataSource();
        dataSource.setUrl(master1Slave1Url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        result.put("ds1_slave1", dataSource);

        return result;
    }

//    @Bean(name = "DuridDataSource")
//    DruidDataSource getDuridDataSource() throws SQLException {
//        dataSource = new DruidDataSource();
//        dataSource.setUrl(master0Url);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//
//        return dataSource;
//    }

//    @Bean
//    SqlSessionFactory getSqlSessionFactory() {
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        org.apache.ibatis.session.Configuration  configuration = new org.apache.ibatis.session.Configuration(environment);
//        configuration.addMapper(TOrderMapper.class);
//        configuration.addMapper(TOrderItemMapper.class);
//
//        return builder.build(configuration);
//    }

    @Bean
    BEDSoftTransaction getSoftTransaction() {
        BEDSoftTransaction transaction = null;
        try {
            // 1. 配置SoftTransactionConfiguration
            SoftTransactionConfiguration transactionConfig = new SoftTransactionConfiguration(myDataSource);
            transactionConfig.setSyncMaxDeliveryTryTimes(3);
            
            NestedBestEffortsDeliveryJobConfiguration configuration = new NestedBestEffortsDeliveryJobConfiguration();
            
            
            transactionConfig.setTransactionLogDataSource(myDataSource);
            // 2. 初始化SoftTransactionManager
            SoftTransactionManager transactionManager = new SoftTransactionManager(transactionConfig);
            transactionManager.init();

            // 3. 获取BEDSoftTransaction
            transaction = (BEDSoftTransaction) transactionManager.getTransaction(SoftTransactionType.BestEffortsDelivery);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transaction;
    }
}
