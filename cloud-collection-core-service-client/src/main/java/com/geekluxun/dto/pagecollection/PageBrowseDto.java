package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.ResponseDataDto;
import lombok.Data;

import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 11:11
 * @Description:
 * @Other:
 */
@Data
public class PageBrowseDto extends ResponseDataDto {
    private int browseTotalCount;
    private Date lastBrowseTime;
    private boolean readed;
}
