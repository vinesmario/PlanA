package com.domain.biz.sale.model.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 销售订单优惠详情
 */
@Data
public class SaleOrderDiscount extends CrudEntity {

    /**
     * 销售订单ID
     */
    private String saleOrderId;

}
