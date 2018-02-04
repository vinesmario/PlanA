package com.common.model.po.uaa;


import com.common.model.CrudEntity;
import lombok.Data;

import java.util.List;

/**
 * 角色
 */
@Data
public class Role extends CrudEntity {

    /**
     * 英文名称
     */
    private String enName;
    /**
     * 模块ID，可能为空
     */
    private String moduleId;
    /**
     * 企业ID，可能为空
     */
    private String companyId;
    /**
     * 部门ID，可能为空
     */
    private String deptId;
    /**
     * 用户列表
     */
    private List<User> userList;

}
