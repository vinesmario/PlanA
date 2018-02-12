package com.common.model.po.biz.sale;

import com.common.model.po.CrudEntity;
import com.common.model.po.biz.provider.LogisticsOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 销售订单
 */
@Data
public class SalesOrder extends CrudEntity {

    /**
     * 订单金额
     */
    private BigDecimal amount;
    /**
     * 实付金额
     */
    private BigDecimal payment;
    /**
     * 支付渠道
     */
    private Byte payChannel;
    /**
     * 状态 1-已下单；2-已支付；3-已发货；4-已收货
     * 21-取消订单；22-支付超时；
     * 31-缺货；32-撤单退款（转退款订单查看状态）；
     * 41-货物丢失；
     * 退货则转退货订单查看状态
     */
    private Integer status;
    /**
     * 退款状态： 0-退款中；1-退款成功；2-退款失败
     */
    private Integer refundStatus;
    /**
     * 退货状态：0-退货中；1-退货成功；2-货物丢失；3-拒绝退货
     */
    private Integer returnStatus;
    /**
     * 销售订单详情
     */
    private List<SalesOrderItem> itemlList;
    /**
     * 物流订单，一对多
     */
    private List<LogisticsOrder> logisticsOrderList;
    /**
     * 退货订单，一对多
     */
    private List<ReturnOrder> returnOrderList;

}
