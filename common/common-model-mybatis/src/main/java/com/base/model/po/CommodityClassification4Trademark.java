package com.base.model.po;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 商标商品/服务项目分类 尼斯协定 工商管理局
 */
@Data
public class CommodityClassification4Trademark extends TreeCrudEntity<CommodityClassification4Trademark> {

    /**
     * 版本，通常是年份。
     */
    private String version;
    /**
     * 编码（与ID同）
     */
    private String code;
}
