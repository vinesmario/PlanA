package com.domain.biz.sale.model.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 销售订单退款详情
 */
@Data
public class SaleOrderRefund extends CrudEntity {

    /**
     * 销售订单ID
     */
    private String saleOrderId;

}
