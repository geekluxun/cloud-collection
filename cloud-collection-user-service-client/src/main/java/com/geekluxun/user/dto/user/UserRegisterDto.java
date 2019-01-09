package com.geekluxun.user.dto.user;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 15:01
 * @Description:
 * @Other:
 */
@Data
public class UserRegisterDto extends RequestParaDto {
    private String name;
    private String email;
    private String password;
}
