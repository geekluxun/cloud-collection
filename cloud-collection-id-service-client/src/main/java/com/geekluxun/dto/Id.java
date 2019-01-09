package com.geekluxun.dto;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2018-08-07 9:54
 * @Description:
 * @Other:
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.Serializable;


@Data
@Log
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Id implements Serializable {

    private static final long serialVersionUID = 6870931236218221183L;
    /**
     * ID类型
     * <P>1位，用来区分两种ID类型:最大峰值型和最小粒度型
     * 0：最大峰值型 1：最小粒度型
     * </P>
     */
    private long type;

    /**
     * 机器ID
     * <P>10位,最多支持1000+个服务器
     */
    private long machine;
    /**
     * 序列号
     * <P> 最大峰值型:
     * <P> 最小粒度型:
     */
    private long seq;
    /**
     * 秒级时间/毫秒级时间
     * <P> 最大峰值型:
     * <P> 最小粒度型:
     */
    private long time;
    /**
     * 生成方式
     * 2位,用来区分三种发布模式: 嵌入发布模式，中心服务器发布模式，REST发布模式.
     * 00：嵌入发布模式 01：中心服务器发布模式 02：REST发布模式 03：保留未用
     */
    private long genMethod;

    /**
     * 版本
     * <P>1位，用来做扩展位或者扩容时候的临时方案。
     * 0：默认值，以免转化为整型再转化回字符串被截断 1：表示扩展或者扩容中
     * </P>
     */
    private long version;
}