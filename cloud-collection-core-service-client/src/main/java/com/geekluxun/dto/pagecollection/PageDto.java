package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.ResponseDataDto;
import lombok.Data;

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
    private String url;
    private String iconUri;
    private PageBrowseDto pageBrowse;
    private Integer level;
}
