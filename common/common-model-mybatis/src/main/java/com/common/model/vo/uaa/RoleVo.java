package com.common.model.vo.uaa;

import com.common.model.ReadVo;
import com.common.model.po.uaa.Module;
import com.common.model.po.uaa.Organ;
import com.common.model.po.uaa.Structure;
import lombok.Data;

/**
 * 角色及其关联
 */
@Data
public class RoleVo extends ReadVo {

    private Module module;

    private Organ company;

    private Structure dept;

}
