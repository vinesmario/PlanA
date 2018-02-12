package com.common.uaa.vo;

import com.common.model.vo.RetrieveVo;
import com.common.uaa.po.Module;
import com.common.uaa.po.Organ;
import com.common.uaa.po.Struct;
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
