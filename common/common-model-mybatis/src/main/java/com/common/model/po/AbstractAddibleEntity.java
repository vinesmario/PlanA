package com.common.model.po;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created and created by date.
 */
@Data
public abstract class AbstractAddibleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 创建者
     */
    @CreatedBy
    private Integer createdBy;
    /**
     * 创建时间
     */
    @CreatedDate
    private Instant createdDate = Instant.now();

}
