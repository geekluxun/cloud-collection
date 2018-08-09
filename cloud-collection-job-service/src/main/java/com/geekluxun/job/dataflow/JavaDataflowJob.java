package com.geekluxun.job.dataflow;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.geekluxun.entity.Foo;
import com.geekluxun.repository.FooRepository;
import com.geekluxun.repository.FooRepositoryFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-09 14:36
 * @Description:
 * @Other:
 */
public class JavaDataflowJob implements DataflowJob<Foo> {

    private FooRepository fooRepository = FooRepositoryFactory.getFooRepository();

    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW FETCH"));
        return fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW PROCESS"));
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
        }
    }
}