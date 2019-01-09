package com.geekluxun.dto.common;

import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 18:06
 * @Description:
 * @Other:
 */
@Data
public class ResponseDto<T> extends BaseDto{
    private int retCode;
    private String  retMsg;
    private T data;
    private long responseId;
}
