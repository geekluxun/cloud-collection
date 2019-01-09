package com.geekluxun.user.dto.user;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

import javax.print.attribute.standard.PrinterURI;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 14:41
 * @Description:
 * @Other:
 */
@Data
public class UserLoginDto extends RequestParaDto {
    private String loginName;
    private String password;
}
