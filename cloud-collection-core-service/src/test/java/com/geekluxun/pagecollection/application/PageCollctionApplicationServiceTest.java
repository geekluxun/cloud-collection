package com.geekluxun.pagecollection.application;

import com.geekluxun.dto.common.ResponseDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: luxun
 * @Create: 2019-01-05 11:14
 * @Description:
 * @Other:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PageCollctionApplicationServiceTest {
    @Autowired
    PageCollctionApplicationServiceImpl pageCollctionService;


    @Test
    public void pageCollect() {
        ResponseDto<Object> responseDto = pageCollctionService.pageCollect(null);
        Assert.assertTrue(responseDto.getRetCode() == 0);
    }
}