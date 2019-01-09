package com.geekluxun.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.geekluxun.job.dataflow.JavaDataflowJob;
import com.geekluxun.job.simple.JavaSimpleJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-09 9:18
 * @Description:
 * @Other:
 */
@Configuration
@ImportResource(locations = {
//        "classpath:spring/spring-elasticjob.xml"
})
public class SpringConfig {

    @Autowired
    CoordinatorRegistryCenter registryCenter;

    @Bean
    public JobScheduler simpleJobSchedule() {
        JobEventConfiguration jobEventConfig = new JobEventRdbConfiguration(setUpEventTraceDataSource());
        JobScheduler jobScheduler = setUpSimpleJob(registryCenter, jobEventConfig);
        jobScheduler.init();
        return jobScheduler;

    }


    @Bean
    public JobScheduler dataFlowJobSchedule() {
        JobEventConfiguration jobEventConfig = new JobEventRdbConfiguration(setUpEventTraceDataSource());
        JobScheduler jobScheduler = setUpDataflowJob(registryCenter, jobEventConfig);
        jobScheduler.init();
        return jobScheduler;

    }

    @Bean
    private static CoordinatorRegistryCenter setUpRegistryCenter() {
        ZookeeperConfiguration zkConfig = new ZookeeperConfiguration("127.0.0.1:2181", "cloud-collecion-job");
        CoordinatorRegistryCenter result = new ZookeeperRegistryCenter(zkConfig);
        result.init();
        return result;
    }


    private JobScheduler setUpSimpleJob(final CoordinatorRegistryCenter regCenter, final JobEventConfiguration jobEventConfig) {
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("javaSimpleJob", "0/5 * * * * ?", 3).shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou").build();
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(coreConfig, JavaSimpleJob.class.getCanonicalName());
        return new JobScheduler(regCenter, LiteJobConfiguration.newBuilder(simpleJobConfig).build(), jobEventConfig);
    }


    private DataSource setUpEventTraceDataSource() {
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName("com.mysql.jdbc.Driver");
        result.setUrl("jdbc:mysql://116.62.63.81:3306/ds0");
        result.setUsername("root");
        result.setPassword("geekluxun");
        return result;
    }

    private JobScheduler setUpDataflowJob(final CoordinatorRegistryCenter regCenter, final JobEventConfiguration jobEventConfig) {
        JobCoreConfiguration coreConfig = JobCoreConfiguration.newBuilder("javaDataflowElasticJob", "0/5 * * * * ?", 3).shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou").build();
        DataflowJobConfiguration dataflowJobConfig = new DataflowJobConfiguration(coreConfig, JavaDataflowJob.class.getCanonicalName(), true);
        return new JobScheduler(regCenter, LiteJobConfiguration.newBuilder(dataflowJobConfig).build(), jobEventConfig);
    }
}
