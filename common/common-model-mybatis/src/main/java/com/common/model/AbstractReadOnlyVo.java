package com.common.model;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for value object which can read only.
 */
@Data
public abstract class AbstractReadOnlyVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 创建者（用户ID）
     */
    private Integer createdBy;
    /**
     * 创建时间
     */
    private Instant createdDate;
    /**
     * 最后修改者（用户ID）
     */
    private Integer lastModifiedBy;
    /**
     * 最后修改时间
     */
    private Instant lastModifiedDate;


}
