package com.model.po.biz.sale;

import com.model.po.CrudEntity;
import com.model.po.biz.provider.LogisticsOrder;
import lombok.Data;

import java.util.List;

/**
 * 发货订单
 */
@Data
public class DeliverOrder extends CrudEntity {

    /**
     * 发货状态：0-退款中；1-退款成功；2-退款失败
     */
    private Integer status;
    /**
     * 销售订单ID
     */
    private Integer salesOrderId;
    /**
     * 物流订单
     */
    private List<LogisticsOrder> logisticsOrderList;

}
