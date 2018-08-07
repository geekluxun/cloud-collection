package com.geekluxun.service.impl.converter;


import com.geekluxun.dto.Id;
import com.geekluxun.service.impl.bean.IdMeta;
import com.geekluxun.service.impl.bean.IdMetaFactory;
import com.geekluxun.service.impl.bean.IdType;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class IdConverterImpl implements IdConverter {

    private IdType idType;

    public IdConverterImpl() {
    }

    public IdConverterImpl(IdType idType) {
        this.idType = idType;
    }

    public long convert(Id id) {

        return doConvert(id, IdMetaFactory.getIdMeta(idType));
    }
    // 78525022364237825  ID(type=0,machine=1,seq=0,time=73145573,genMethod=0,version=0)  idMeta(machineBits = 10, seqBits = 20, timeBits = 30, genMethodBIts = 2, typeBits = 1, versionBits = 1)

    /**
     *
     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000

     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0001 //第1步 0与1进行按位或操作

     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0000 //第2.1步 seq的值(1)与SeqBitsStartPos(10)移位操作-> 1 * (2^10)
     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0001 //第2.2步 2.1得到的结果(1025)与ret(1)进行按位或操作-> ret = 1 * (2^10) + 1 = 1025

     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0000 //第3.1步 time的值(12)与TimeBitsStartPos(30)移位操作-> 12 * (2^30)
     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0001 //第3.2步 2.1得到的结果(1025)与ret(1)进行按位或操作-> ret = 12 * (2^30) + 1025 = 12884902913

     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0000 //第4.1步 genMethod的值(0)与GenMethodBitsStartPos(60)移位操作-> 0 * (2^60)
     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0001 //第4.2步 2.1得到的结果(1025)与ret(1)进行按位或操作-> ret = 0 * (2^60) + 12884902913 = 12884902913

     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0000 //第5.1步 type的值(0)与GenMethodBitsStartPos(62)移位操作-> 0 * (2^62)
     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0001 //第5.2步 2.1得到的结果(1025)与ret(1)进行按位或操作-> ret = 0 * (2^62) + 12884902913 = 12884902913

     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0000 //第6.1步 type的值(1)与VersionBitsStartPos(63)移位操作-> 1 * (2^63)
     0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0100 0000 0001 //第6.2步 2.1得到的结果(1025)与ret(1)进行按位或操作-> ret = 1 * (2^63) + 12884902913 = -9223372023969872895
     long的取值范围为（-9223372036854774808~9223372036854774807），占用8个字节（-2的63次方到2的63次方-1）
     */
    protected long doConvert(Id id, IdMeta idMeta) {
        long ret = 0;

        ret |= id.getMachine(); //等价于  ret = ret | id.getMachine() -> 0000 0000 | 0000 0001 = 0000 0001(1)
        //等价于 ret |= seq * 2^machineBit
        ret |= id.getSeq() << idMeta.getSeqBitsStartPos();
        //等价于: ret |= time * 2^(machineBit + seqBits)
        ret |= id.getTime() << idMeta.getTimeBitsStartPos();
        //等价于: ret |= genMethod * 2^(machineBits + seqBits + timeBits)
        ret |= id.getGenMethod() << idMeta.getGenMethodBitsStartPos();
        //等价于: ret |= type * 2^(machineBits + seqBits + timeBits + genMethodBits)
        ret |= id.getType() << idMeta.getTypeBitsStartPos();
        //等价于: ret |= version * 2^(machineBits + seqBits + timeBits + genMethodBits + typeBits)
        ret |= id.getVersion() << idMeta.getVersionBitsStartPos();

        return ret;
    }

    public Id convert(long id) {
        return doConvert(id, IdMetaFactory.getIdMeta(idType));
    }

    protected Id doConvert(long id, IdMeta idMeta) {
        Id ret = new Id();

        ret.setMachine(id & idMeta.getMachineBitsMask());

        ret.setSeq((id >>> idMeta.getSeqBitsStartPos()) & idMeta.getSeqBitsMask());

        ret.setTime((id >>> idMeta.getTimeBitsStartPos()) & idMeta.getTimeBitsMask());

        ret.setGenMethod((id >>> idMeta.getGenMethodBitsStartPos()) & idMeta.getGenMethodBitsMask());

        ret.setType((id >>> idMeta.getTypeBitsStartPos()) & idMeta.getTypeBitsMask());

        ret.setVersion((id >>> idMeta.getVersionBitsStartPos()) & idMeta.getVersionBitsMask());

        return ret;
    }
}
