package com.common.model;

import com.common.model.po.uaa.Account;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by and created,
 * last modified by date.
 */
@Data
public abstract class AbstractAuditingVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Account createdBy;

    private Instant createdDate;

    private Account lastModifiedBy;

    private Instant lastModifiedDate;


}
