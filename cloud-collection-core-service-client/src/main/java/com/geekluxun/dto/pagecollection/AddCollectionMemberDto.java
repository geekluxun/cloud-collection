package com.geekluxun.dto.pagecollection;

import com.geekluxun.dto.common.RequestParaDto;
import lombok.Data;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-08 10:24
 * @Description:
 * @Other:
 */
@Data
public class AddCollectionMemberDto extends RequestParaDto {
    private String memberId;
}
