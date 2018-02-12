package com.common.model.vo.uaa;

import com.common.model.po.uaa.Module;
import com.common.model.po.uaa.Organ;
import com.common.model.po.uaa.Struct;
import com.common.model.vo.RetrieveVo;
import com.common.model.po.uaa.Module;
import com.common.model.vo.RetrieveVo;
import lombok.Data;

/**
 * 角色及其关联
 */
@Data
public class RoleVo extends RetrieveVo {

    private Module module;

    private Organ company;

    private Struct dept;

}
