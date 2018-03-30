package com.domain.biz.sale.model.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 销售订单退货详情
 */
@Data
public class SaleOrderReturn extends CrudEntity {

    /**
     * 退货状态 0-退货中；1-退货成功；2-货物丢失；3-拒绝退货
     */
    private Byte status;
    /**
     * 销售订单ID
     */
    private Long salesOrderId;

}
