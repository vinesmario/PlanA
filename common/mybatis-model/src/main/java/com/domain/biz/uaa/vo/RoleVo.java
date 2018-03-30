package com.domain.biz.uaa.vo;

import com.domain.biz.model.vo.RetrieveVo;
import com.domain.biz.uaa.po.Module;
import com.domain.biz.uaa.po.Organ;
import com.domain.biz.uaa.po.Struct;
import lombok.Data;

/**
 * 角色及其关联
 */
@Data
public class RoleVo extends RetrieveVo {

    private Module module;

    private Organ company;

    private Struct struct;

}
