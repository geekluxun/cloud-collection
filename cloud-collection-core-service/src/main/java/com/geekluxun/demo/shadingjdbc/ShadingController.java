package com.geekluxun.demo.shadingjdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.geekluxun.dao.TOrderMapper;
import com.geekluxun.entity.TOrder;
import com.geekluxun.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-07 16:21
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/shadingjdbc")
public class ShadingController {
    
    @Autowired
    TOrderMapper tOrderMapper;
    
    @Autowired
    IdService idService;
    
    @RequestMapping("/save")
    public void save(){
        TOrder order = new TOrder();
        order.setId(idService.genId());
        order.setUserId(idService.genId());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        tOrderMapper.insert(order);
        DruidDataSource druidDataSource;
    }
}
