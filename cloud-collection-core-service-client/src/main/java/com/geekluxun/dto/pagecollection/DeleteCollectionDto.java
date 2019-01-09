package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 9:15
 * @Description:
 * @Other:
 */
@Data
public class DeleteCollectionDto extends RequestParaDto {
    private String collectionId;
}
