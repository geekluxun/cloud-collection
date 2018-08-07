package com.geekluxun.service.impl.converter;


import com.geekluxun.dto.Id;

/**
 * ID转换器
 * <p>ID对象和long之间的转换</p>
 */
public interface IdConverter {

	long convert(Id id);

	Id convert(long id);

}
