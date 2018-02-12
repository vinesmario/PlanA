package com.biz.comodity.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 可交易商品
 * <p>
 * hat scarf clothes necktie coat sweater suit shirts underwear trousers shoes
 */
@Data
public class Commodity extends CrudEntity {

    private Integer colorId;
}
