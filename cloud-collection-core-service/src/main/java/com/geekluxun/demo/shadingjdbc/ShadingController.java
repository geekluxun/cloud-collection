package com.geekluxun.demo.shadingjdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.geekluxun.dao.TOrderMapper;
import com.geekluxun.entity.TOrder;
import com.geekluxun.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

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
    @ResponseBody
    public Object save(){
        TOrder order = new TOrder();
        order.setId(123L);
        order.setUserId(456L);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        tOrderMapper.insertSelective(order);
        order = tOrderMapper.selectByPrimaryKey(1L);
        int count = tOrderMapper.count();
        return new HashMap<>();
    }
}
