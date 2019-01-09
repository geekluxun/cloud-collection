package com.geekluxun.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.geekluxun.dto.Id;
import com.geekluxun.service.IdService;
import com.geekluxun.service.impl.bean.IdType;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service(timeout = 5000)
public class IdServiceImpl extends AbstractIdServiceImpl implements IdService {
    private long sequence = 0;

    private long lastTimestamp = -1;

    private Lock lock = new ReentrantLock();

    public IdServiceImpl() {
        super();
    }

    public IdServiceImpl(String type) {
        super(type);
    }

    public IdServiceImpl(IdType type) {
        super(type);
    }

    protected void populateId(Id id) {
        lock.lock();
        try {
            long timestamp = this.genTime();
            validateTimestamp(lastTimestamp, timestamp);

            if (timestamp == lastTimestamp) {
                sequence++;
                sequence &= idMeta.getSeqBitsMask();
                if (sequence == 0) {
                    timestamp = this.tillNextTimeUnit(lastTimestamp);
                }
            } else {
                lastTimestamp = timestamp;
                sequence = 0;
            }

            id.setSeq(sequence);
            id.setTime(timestamp);

        } finally {
            lock.unlock();
        }
    }

    private void validateTimestamp(long lastTimestamp, long timestamp) {
        if (timestamp < lastTimestamp) {
            if (log.isErrorEnabled())
                log.error(String
                        .format("Clock moved backwards.  Refusing to generate id for %d %s.",
                                lastTimestamp - timestamp,
                                idType == IdType.MAX_PEAK ? "second"
                                        : "milisecond"));

            throw new IllegalStateException(
                    String.format(
                            "Clock moved backwards.  Refusing to generate id for %d %s.",
                            lastTimestamp - timestamp,
                            idType == IdType.MAX_PEAK ? "second" : "milisecond"));
        }
    }

    protected long tillNextTimeUnit(final long lastTimestamp) {
        if (log.isInfoEnabled())
            log.info(String
                    .format("Ids are used out during %d in machine %d. Waiting till next %s.",
                            lastTimestamp, machineId,
                            idType == IdType.MAX_PEAK ? "second" : "milisecond"));

        long timestamp = this.genTime();
        while (timestamp <= lastTimestamp) {
            timestamp = this.genTime();
        }

        if (log.isInfoEnabled())
            log.info(String.format("Next %s %d is up.",
                    idType == IdType.MAX_PEAK ? "second" : "milisecond",
                    timestamp));

        return timestamp;
    }
}
