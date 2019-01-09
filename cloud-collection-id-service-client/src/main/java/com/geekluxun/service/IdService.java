package com.geekluxun.service;

import com.geekluxun.dto.Id;

import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-07 10:02
 * @Description:
 * @Other:
 */
public interface IdService {

    /**
     * 产生ID
     * <P>根据系统时间产生一个全局唯一的ID</P>
     */
    long genId();

    /**
     * 反解ID
     * <P>对产生的ID进行反解</P>
     */
    Id expId(long id);

    /**
     * 翻译时间
     * <P>把长整形的时间转化成可读的格式</P>
     *
     * @param time
     * @return
     */
    Date transTime(long time);

    /**
     * 制造ID
     * <P>通过给定的ID元素来制造ID</P>
     */
    long makeId(long time, long seq);

    /**
     * 制造ID
     * <P>通过给定的ID元素来制造ID</P>
     */
    long makeId(long time, long seq, long machine);

    /**
     * 制造ID
     * <P>通过给定的ID元素来制造ID</P>
     */
    long makeId(long genMethod, long time, long seq, long machine);

    /**
     * 制造ID
     * <P>通过给定的ID元素来制造ID</P>
     */
    long makeId(long type, long genMethod, long time,
                long seq, long machine);

    /**
     * 制造ID
     * <P>通过给定的ID元素来制造ID</P>
     */
    long makeId(long version, long type, long genMethod,
                long time, long seq, long machine);

}
