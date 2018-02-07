package com.common.model.po.biz.trade;

import com.common.model.CrudEntity;
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
     * 采购订单ID
     */
    private String purchaseOrderId;

}
