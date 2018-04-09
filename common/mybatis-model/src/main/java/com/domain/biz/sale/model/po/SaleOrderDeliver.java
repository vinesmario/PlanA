package com.domain.biz.sale.model.po;

import com.domain.biz.model.po.CrudEntity;
import com.domain.biz.provider.model.po.LogisticsOrder;
import lombok.Data;

import java.util.List;

/**
 * 销售订单发货详情
 */
@Data
public class SaleOrderDeliver extends CrudEntity {

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
