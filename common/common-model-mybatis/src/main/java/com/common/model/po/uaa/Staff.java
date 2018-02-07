package com.common.model.po.uaa;

import com.common.model.TreeCrudEntity;
import lombok.Data;

/**
 * 职工
 * 对应的用户角色ID相同，传递架构的上下级关系。
 * 对应的用户角色ID不同，视为平级关系，需要创建关系表。
 * 每个架构可以虚拟一个超级管理员用户，以企业邮箱为用户名
 */
@Data
public class Staff extends TreeCrudEntity<Staff> {

    /**
     * 性别
     */
    private String gender;
    /**
     * 部门ID，不能为空
     */
    private String structureId;
    /**
     * 企业ID，不能为空
     */
    private String organId;
    /**
     * 用户ID，可能为空
     */
    private String userId;


}
