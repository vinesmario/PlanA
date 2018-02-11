package com.model.dto.pay;

import com.common.model.dto.CrudDto;
import com.model.dto.CrudDto;
import lombok.Data;

/**
 * 支付订单-银联
 */
@Data
public class PayOrderUnionDto extends CrudDto {


    /**
     *
     */
    private Byte status;
    /**
     * 交易订单ID，可能为空，视具体业务
     */
    private Integer tradeOrderId;
    /**
     * 充值订单ID，可能为空，视具体业务
     */
    private Integer chargeOrderId;
}
