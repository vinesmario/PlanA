package com.common.uaa.vo;

import com.common.model.vo.TreeRetrieveVo;
import com.common.uaa.po.Organ;
import lombok.Data;

/**
 * 部门及其关联
 */
@Data
public class StructVo extends TreeRetrieveVo<StructVo> {

    private Organ organ;

}
