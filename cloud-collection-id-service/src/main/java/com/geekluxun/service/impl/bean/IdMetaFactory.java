package com.geekluxun.service.impl.bean;

/**
 * IdMeta工厂类
 */
public class IdMetaFactory {
    /**
     *
     */
    private static IdMeta maxPeak = new IdMeta((byte) 10, (byte) 20, (byte) 30, (byte) 2, (byte) 1, (byte) 1);

    /**
     *
     */
    private static IdMeta minGranularity = new IdMeta((byte) 10, (byte) 10, (byte) 40, (byte) 2, (byte) 1, (byte) 1);

    public static IdMeta getIdMeta(IdType type) {
        if (IdType.MAX_PEAK.equals(type)) {
            return maxPeak;
        } else if (IdType.MIN_GRANULARITY.equals(type)) {
            return minGranularity;
        } else {
            throw new RuntimeException("不支持的IdMeta");
        }
    }
}
