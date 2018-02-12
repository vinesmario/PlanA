package com.base.model.po;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 统计用产品分类 统计局
 */
@Data
public class ProductClassification extends TreeCrudEntity<ProductClassification> {

    /**
     * 版本，通常是年份。
     */
    private String version;
    /**
     * 编码
     */
    private String code;
}
