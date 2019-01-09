package com.geekluxun.user.dto.user;

import com.geekluxun.dto.common.ResponseDataDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 14:42
 * @Description:
 * @Other:
 */
@Data
public class UserLoginResponseDto extends ResponseDataDto {
    private String userId;
    private String loginToken;
}
