package com.geekluxun.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-09 9:12
 * @Description:
 * @Other:
 */
public class MyElasticJob implements SimpleJob {
    
    @Override
    public void execute(ShardingContext context) {
        System.out.println("任务执行开始....");
        switch (context.getShardingItem()) {
            case 0:{
                // do something by sharding item 0
                System.out.println("分片0任务处理");
                break;
            }
            case 1:{
                // do something by sharding item 1
                System.out.println("分片1任务处理");
                break;
            }
            case 2:{
                // do something by sharding item 1
                System.out.println("分片2任务处理");
                break;
            }
        }
    }
}
