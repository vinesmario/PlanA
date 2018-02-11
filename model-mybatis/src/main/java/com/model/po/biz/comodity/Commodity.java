package com.model.po.biz.comodity;

import com.model.po.CrudEntity;
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
