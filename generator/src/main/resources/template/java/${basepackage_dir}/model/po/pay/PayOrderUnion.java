package com.model.po.pay;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 支付订单-银联支付
 */
@Data
public class PayOrderUnion extends CrudEntity {


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
