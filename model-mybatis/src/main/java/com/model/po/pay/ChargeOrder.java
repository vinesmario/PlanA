package com.model.po.pay;

import com.model.po.CrudEntity;
import lombok.Data;

/**
 * 充值订单(如果存在钱包业务)
 */
@Data
public class ChargeOrder extends CrudEntity {

    /**
     * 充值状态 0-充值中；1-充值成功；2-充值失败
     */
    private Integer status;


}
