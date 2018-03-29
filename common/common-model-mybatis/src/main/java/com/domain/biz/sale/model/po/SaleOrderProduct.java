package com.domain.biz.sale.model.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 销售订单产品详情
 */
@Data
public class SaleOrderProduct extends CrudEntity {

    /**
     * 销售订单ID
     */
    private String salesOrderId;
}
