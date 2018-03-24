package com.pay.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 支付交易流水-银联支付
 */
@Data
public class PayTradeUnion extends CrudEntity {


    /**
     * 支付状态：0-支付中；1-支付成功；2-支付失败
     */
    private Integer status;
    /**
     * 销售订单ID，可能为空，视具体业务
     */
    private Integer salesOrderId;
    /**
     * 充值订单ID，可能为空，视具体业务
     */
    private Integer chargeOrderId;
}
