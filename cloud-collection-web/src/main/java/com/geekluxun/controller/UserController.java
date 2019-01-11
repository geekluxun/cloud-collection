package com.geekluxun.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.service.TestService;
import com.geekluxun.user.application.UserApplicationService;
import com.geekluxun.user.dto.user.UserRegisterDto;
import com.geekluxun.user.dto.user.UserRegisterResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 16:07
 * @Description:
 * @Other:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserApplicationService userService;

    @Reference
    private TestService testService;

    @PostMapping("/register")
    @ResponseBody
    public Object login(@RequestBody RequestDto<UserRegisterDto> requestDto) {
        ResponseDto<UserRegisterResponseDto> responseDto = userService.register(requestDto);

        return responseDto;
    }
    
    
    @GetMapping("/test")
    public Object test(){
        return "dd";
    }
}