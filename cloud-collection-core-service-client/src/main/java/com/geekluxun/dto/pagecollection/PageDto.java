package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.ResponseDataDto;
import lombok.Data;

import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 11:05
 * @Description:
 * @Other:
 */
@Data
public class PageDto extends ResponseDataDto {
    private String pageId;
    private String name;
    private String url;
    private String iconUri;
    private int browseTotalCount;
    private Date lastBrowseTime;
    private boolean readed;
    private Integer level;
}
