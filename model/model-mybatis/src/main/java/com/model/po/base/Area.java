package com.model.po.base;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 行政区划，以统计局公布信息为准
 */
@Data
public class Area extends TreeCrudEntity<Area> {

    /**
     * 版本，通常是年份。
     */
    private String version;
    /**
     * 编码
     */
    private String code;
    /**
     * 等级（1：省级；2：地市级别；3：区县级别；4：乡镇街道）
     */
    private Byte level;
    /**
     * 地址
     */
    private String address;
    /**
     * 国内邮政编码
     */
    private String postalCode;
    /**
     * 国际邮政编码
     */
    private String zipCode;
    /**
     * 电话区号
     */
    private String diallingCode;
    /**
     * 车牌号首两位
     */
    private String carNumberPlate;
}
