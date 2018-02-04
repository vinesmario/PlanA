package com.common.model.po.base;

import com.common.model.TreeCrudEntity;
import lombok.Data;

/**
 * 区域
 */
@Data
public class Area extends TreeCrudEntity<Area> {

    /**
     * 行政编码（与ID同）
     */
    private Integer code;
    /**
     * 区域等级（1：省级；2：地市级别；3：区县级别；4：乡镇街道）
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
