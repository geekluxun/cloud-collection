package com.geekluxun.demo.shadingjdbc;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.geekluxun.dao.TOrderItemMapper;
import com.geekluxun.dao.TOrderMapper;
import com.geekluxun.entity.TOrder;
import com.geekluxun.entity.TOrderItem;
import com.geekluxun.service.IdService;
import io.shardingsphere.transaction.bed.BEDSoftTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
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
    TOrderItemMapper orderItemMapper;

    //@Autowired
    @Reference
    IdService idService;


    //@Resource(name = "DuridDataSource")
    @Autowired
    DataSource dataSource;

    //@Autowired
    BEDSoftTransaction transaction;


    @RequestMapping("/save/order")
    @ResponseBody
    public Object saveOrder() {
        TOrder order = new TOrder();
        order.setId((long) new Random(47).nextInt(9999));
        order.setUserId(idService.genId());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        tOrderMapper.insertSelective(order);
        TOrderItem orderItem = new TOrderItem();
        orderItem.setId(idService.genId());
        orderItem.setOrderId(order.getId());
        orderItem.setAmount(new BigDecimal("10"));
        orderItem.setCreateTime(new Date());
        orderItem.setUpdateTime(new Date());
        orderItemMapper.insertSelective(orderItem);

        HashMap response = new HashMap();
        response.put("response:", "ok");
        return response;
    }


    @RequestMapping("/all/order")
    @ResponseBody
    public Object query() {
        int count = orderItemMapper.count();
        System.out.println("订单总共个数:" + count);

        List<TOrder> list = tOrderMapper.selectAll();
        System.out.println("各个元素:" + JSON.toJSONString(list));
        HashMap para = new HashMap(10);
        para.put("total", count);
        para.put("data:", list);
        return para;
    }

    @RequestMapping("/all/item")
    @ResponseBody
    public Object queryAllOrderItem() {
        int count = orderItemMapper.count();
        System.out.println("订单明细总共个数:" + count);

        List<TOrderItem> list = orderItemMapper.selectAll();
        System.out.println("各个元素:" + JSON.toJSONString(list));
        HashMap para = new HashMap(10);
        para.put("total", count);
        para.put("data:", list);
        return para;
    }

    /**
     * 据说这个柔性事务还是有问题的，暂时未测通
     *
     * @return
     */
    @RequestMapping("/transaction")
    @ResponseBody
    public Object transactionTest() {
        try {
            // 4. 开启事务
            transaction.begin(dataSource.getConnection());
            String id = transaction.getTransactionId();
            Connection connection = transaction.getConnection();

            // 5. 执行JDBC
            saveOrder();
            int value = 0 / 0;
            // 6.关闭事务
            transaction.end();
        } catch (Exception e) {
            e.printStackTrace();
            HashMap response = new HashMap();
            response.put("response", "failure");
            return response;
        }
        HashMap response = new HashMap();
        response.put("response", "ok");
        return response;
    }
}
