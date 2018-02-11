package com.model.vo.uaa;

import com.model.po.uaa.Module;
import com.model.po.uaa.Organ;
import com.model.po.uaa.Struct;
import com.model.vo.RetrieveVo;
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
