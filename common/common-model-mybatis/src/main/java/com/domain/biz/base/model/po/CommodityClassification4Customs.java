package com.domain.biz.base.model.po;


import com.domain.biz.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 海关征税使用《商品名称及编码协调制度》 HS
 */
@Data
public class CommodityClassification4Customs extends TreeCrudEntity<CommodityClassification4Customs> {

    /**
     * 版本，通常是年份。
     */
    private String version;
    /**
     * 编码
     */
    private String code;

}
