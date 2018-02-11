package com.model.po.biz.purchase;

import com.common.model.po.CrudEntity;
import com.model.po.CrudEntity;
import lombok.Data;

/**
 * 材料供应商
 */
@Data
public class Supplier extends CrudEntity {

    private Integer organId;

    private Integer structId;
}
