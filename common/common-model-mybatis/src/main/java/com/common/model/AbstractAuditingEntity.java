package com.common.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@Data
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 创建者（用户ID）
     */
    @CreatedBy
    private Integer createdBy;
    /**
     * 创建时间
     */
    @CreatedDate
    private Instant createdDate = Instant.now();
    /**
     * 最后修改者（用户ID）
     */
    @LastModifiedBy
    private Integer lastModifiedBy;
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();


}
