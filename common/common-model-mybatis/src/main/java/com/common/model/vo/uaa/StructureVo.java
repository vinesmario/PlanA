package com.common.model.vo.uaa;

import com.common.model.TreeReadVo;
import com.common.model.po.uaa.Organ;
import lombok.Data;

/**
 * 部门及其关联
 */
@Data
public class StructureVo extends TreeReadVo<StructureVo> {

    private Organ organ;

}
