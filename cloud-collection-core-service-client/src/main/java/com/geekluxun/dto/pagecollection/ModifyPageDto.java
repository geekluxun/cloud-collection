package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 10:20
 * @Description:
 * @Other:
 */
@Data
public class ModifyPageDto extends RequestParaDto {
    private String pageId;
    private String newName;
    private Integer newLevel;
}
