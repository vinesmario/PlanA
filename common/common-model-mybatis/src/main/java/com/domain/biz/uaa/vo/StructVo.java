package com.domain.biz.uaa.vo;

import com.domain.biz.model.vo.TreeRetrieveVo;
import com.domain.biz.uaa.po.Organ;
import lombok.Data;

/**
 * 部门及其关联
 */
@Data
public class StructVo extends TreeRetrieveVo<StructVo> {

    private Organ organ;

}
