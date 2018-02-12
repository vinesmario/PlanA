package com.biz.sale.model.po;

import com.biz.provider.model.po.LogisticsOrder;
import com.common.model.po.CrudEntity;
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
	private Long salesOrderId;
	/**
	 * 物流订单
	 */
	private List<LogisticsOrder> logisticsOrderList;

}
