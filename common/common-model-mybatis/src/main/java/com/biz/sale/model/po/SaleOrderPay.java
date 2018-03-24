package com.biz.sale.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 销售订单支付详情
 */
@Data
public class SaleOrderPay extends CrudEntity {

    /**
     * 销售订单ID
     */
    private String saleOrderId;

}
