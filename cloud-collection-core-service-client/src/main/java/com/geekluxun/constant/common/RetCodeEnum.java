package com.geekluxun.constant.common;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-08 16:14
 * @Description:
 * @Other:
 */

public enum RetCodeEnum {

    RET_SUCCESS(0, "成功"),
    RET_FAILURE(9999, "失败");

    private int code;
    private String msg;


    RetCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
