package com.biz.purchase.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 材料供应商
 */
@Data
public class Supplier extends CrudEntity {

	private Long organId;

	private Long structId;
}
