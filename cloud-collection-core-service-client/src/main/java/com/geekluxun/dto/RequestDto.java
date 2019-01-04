package com.geekluxun.dto;

import lombok.Data;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 18:26
 * @Description:
 * @Other:
 */
@Data
public class RequestDto<T> {
    T requestPara;
    long requestId;
}
