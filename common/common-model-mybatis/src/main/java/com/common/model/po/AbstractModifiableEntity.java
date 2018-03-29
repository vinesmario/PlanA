package com.common.model.po;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by
 * and created,last modified by date.
 */
@Data
public abstract class AbstractModifiableEntity extends AbstractAddibleEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 最后修改者
     */
    @LastModifiedBy
    private Integer lastModifiedBy;
    /**
     * 最后修改时间
     */
    @LastModifiedDate
    private Instant lastModifiedDate = Instant.now();


}
