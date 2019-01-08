package com.geekluxun.pagecollection.domain.valobj;

import com.geekluxun.common.ValueObject;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 15:08
 * @Description:
 * @Other:
 */
public enum  PageImportanceLevelEnum  {
    
    HiGH(3, "重要"),
    NORMAL(2, "一般"),
    LOW(1,"低");
    
    private int level;
    private String desc;

    PageImportanceLevelEnum(int level, String desc){
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public static PageImportanceLevelEnum getPageImportanceLevelEnumByLevel(int level){
        PageImportanceLevelEnum levelEnum = null;
        switch (level){
            case 1:{
                levelEnum = LOW;
                break;
            }
            case 2:{
                levelEnum = NORMAL; 
                break;
            }
            case 3:{
                levelEnum = HiGH;
                break;
            }
            default:{
                throw new RuntimeException("不支持的枚举类型");
            }
        }
        return levelEnum;
    }
}
