package com.geekluxun.pagecollection.domain.valobj;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:34
 * @Description:
 * @Other:
 */
public enum CollectionMemberTypeEnum {
    PAGE(1, "网页"),
    COLLECTION(2, "收藏夹");

    private int type;
    private String desc;

    CollectionMemberTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CollectionMemberTypeEnum getCollectionMemberTypeEnumByType(int type) {
        CollectionMemberTypeEnum memberTypeEnum = null;
        for (CollectionMemberTypeEnum typeEnum : CollectionMemberTypeEnum.values()) {
            if (typeEnum.getType() == type) {
                memberTypeEnum = typeEnum;
                break;
            }
        }
        if (memberTypeEnum == null) {
            throw new RuntimeException("枚举类型不存在");
        }
        return memberTypeEnum;
    }
}
