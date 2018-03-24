package com.biz.sale.model.po;

import com.common.model.po.CrudEntity;
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
