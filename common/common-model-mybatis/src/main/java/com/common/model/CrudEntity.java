package com.common.model;

import lombok.Data;

@Data
public class CrudEntity extends AbstractAuditingEntity {

    /**
     * ID，主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 备注
     */
    private String memo;
    /**
     * 删除标识
     */
    private Byte delFlag;

}
