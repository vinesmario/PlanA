package com.domain.common.model.mybatis.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created and created by date.
 */
@Accessors(chain = true)
@Builder
@Data
public abstract class AbstractAddibleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    private Integer createdBy;
    /**
     * 创建时间
     */
    private Instant createdDate = Instant.now();

}
