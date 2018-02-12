package com.common.model.vo.biz;

import com.common.model.vo.RetrieveVo;
import com.common.model.po.base.Color;
import com.common.model.po.base.Size;
import com.common.model.po.base.Size;
import com.common.model.vo.RetrieveVo;
import lombok.Data;

/**
 * 可交易商品
 */
@Data
public class CommodityVo extends RetrieveVo {

    private Color color;

    private Size size;

}
