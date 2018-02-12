package com.common.biz.sale.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 退货订单
 */
@Data
public class ReturnOrder extends CrudEntity {

    /**
     * 退货状态 0-退货中；1-退货成功；2-货物丢失；3-拒绝退货
     */
    private Byte status;
    /**
     * 销售订单ID
     */
    private Long salesOrderId;

}
