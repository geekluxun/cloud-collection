package com.geekluxun.config.apollo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-25 15:26
 * @Description:
 * @Other:
 */
@Data
public class ConfigDemoBean {
    @Value("${userName:luxun}")
    private String userName;
    @Value("${password:123}")
    private String password;
}
