package com.domain.biz.purchase.model.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 材料供应商
 */
@Data
public class Supplier extends CrudEntity {

	private Long organId;

	private Long structId;
}
