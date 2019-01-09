package com.geekluxun.user.application;

import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.user.dto.user.UserLoginDto;
import com.geekluxun.user.dto.user.UserLoginResponseDto;
import com.geekluxun.user.dto.user.UserRegisterDto;
import com.geekluxun.user.dto.user.UserRegisterResponseDto;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 14:29
 * @Description:
 * @Other:
 */
public interface UserApplicationService {


    /**
     * 用户登录
     *
     * @param requestDto
     * @return
     */

    ResponseDto<UserLoginResponseDto> login(RequestDto<UserLoginDto> requestDto);


    /**
     * 用户注册
     *
     * @return
     */
    ResponseDto<UserRegisterResponseDto> register(RequestDto<UserRegisterDto> requestDto);
}
