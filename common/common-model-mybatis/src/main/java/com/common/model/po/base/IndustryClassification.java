package com.common.model.po.base;

import com.common.model.TreeCrudEntity;
import lombok.Data;

/**
 * 行业分类 国家标准
 */
@Data
public class IndustryClassification extends TreeCrudEntity<IndustryClassification> {

    /**
     * 版本，通常是年份。
     */
    private String version;
    /**
     * 编码
     */
    private String code;
    /**
     * 等级
     */
    private Byte level;

}
