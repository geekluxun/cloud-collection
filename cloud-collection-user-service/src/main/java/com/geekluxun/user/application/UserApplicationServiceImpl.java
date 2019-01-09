package com.geekluxun.user.application;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.service.IdService;
import com.geekluxun.user.domain.entity.User;
import com.geekluxun.user.domain.valobj.UserId;
import com.geekluxun.user.dto.user.UserLoginDto;
import com.geekluxun.user.dto.user.UserLoginResponseDto;
import com.geekluxun.user.dto.user.UserRegisterDto;
import com.geekluxun.user.dto.user.UserRegisterResponseDto;
import com.geekluxun.user.repo.dao.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright,2018-2019,xinxindai Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 14:29
 * @Description:
 * @Other:
 */
@Service(timeout = 5000)
public class UserApplicationServiceImpl implements UserApplicationService {

    @Autowired
    private TUserMapper userMapper;

    @Reference
    private IdService idService;

    /**
     * 用户登录
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<UserLoginResponseDto> login(RequestDto<UserLoginDto> requestDto) {
        ResponseDto<UserLoginResponseDto> responseDto = new ResponseDto<>();

        // TODO
        return responseDto;
    }


    /**
     * 用户注册
     *
     * @return
     */
    @Transactional
    public ResponseDto<UserRegisterResponseDto> register(RequestDto<UserRegisterDto> requestDto) {
        ResponseDto<UserRegisterResponseDto> responseDto = new ResponseDto<>();
        UserRegisterDto requestPara = requestDto.getRequestPara();

        UserId userId = new UserId("U" + idService.genId());
        User user = new User(userId, requestPara.getName(), requestPara.getEmail(), requestPara.getPassword());

        userMapper.insert(user);

        UserRegisterResponseDto registerResponseDto = new UserRegisterResponseDto();
        registerResponseDto.setUserId(user.getUserId().id());
        responseDto.setData(registerResponseDto);
        return responseDto;
    }
}
