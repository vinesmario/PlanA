package com.domain.biz.purchase.model.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

import java.util.List;

/**
 * 采购订单
 */
@Data
public class PurchaseOrder extends CrudEntity {

    /**
     * 采购订单详情
     */
    private List<PurchaseOrderItem> itemlList;
}
