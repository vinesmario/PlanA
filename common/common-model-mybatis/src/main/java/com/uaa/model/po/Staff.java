package com.uaa.model.po;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 职工
 * 两个职工的用户角色ID相同，可以传递部门的上下级关系。
 * 两个对应的用户角色ID不同，视为平级关系，可以创建关系表。
 * 每个部门可以虚拟一个超级管理员用户，以企业邮箱为用户名
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
    private Integer structId;
    /**
     * 企业ID，不能为空
     */
    private Integer organId;
    /**
     * 用户ID，可能为空
     */
    private Integer userId;


}
