package com.model.po.uaa;


import com.model.po.CrudEntity;
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
    private String organId;
    /**
     * 部门ID，可能为空
     */
    private String structId;
    /**
     * 用户列表
     */
    private List<User> userList;

}
