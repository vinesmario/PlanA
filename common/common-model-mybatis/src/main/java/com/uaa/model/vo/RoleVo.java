package com.uaa.model.vo;

import com.common.model.vo.RetrieveVo;
import com.uaa.model.po.Module;
import com.uaa.model.po.Organ;
import com.uaa.model.po.Struct;
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
