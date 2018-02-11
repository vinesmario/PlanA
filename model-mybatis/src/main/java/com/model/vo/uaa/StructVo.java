package com.model.vo.uaa;

import com.model.po.uaa.Organ;
import com.model.vo.TreeRetrieveVo;
import lombok.Data;

/**
 * 部门及其关联
 */
@Data
public class StructVo extends TreeRetrieveVo<StructVo> {

    private Organ organ;

}
