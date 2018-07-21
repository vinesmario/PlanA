package com.domain.common.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Base abstract class for entities which will
 * Create new records
 * Retrieve existing records
 * Update existing records
 * Delete existing records.
 */
@Accessors(chain = true)
@Data
public class CrudEntity extends AbstractModifiableEntity {

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
