package com.common.model.po.uaa;

import com.common.model.TreeCrudEntity;
import lombok.Data;

/**
 * 职工，存在上下级关系
 */
@Data
public class Staff extends TreeCrudEntity<Staff> {

    /**
     * 性别
     */
    private String gender;
    /**
     * 部门ID
     */
    private String structureId;
    /**
     * 企业ID
     */
    private String organId;
    /**
     * 用户ID，可能为空
     */
    private String userId;


}
