package com.domain.biz.model.vo;

import lombok.Data;

import java.time.Instant;

/**
 * Base class for value object which can retrieve only.
 */
@Data
public class RetrieveVo {

    private Long id;

    private String name;

    private String memo;

    private String delFlag;

    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    private Integer createdBy;
    /**
     * 创建时间
     */
    private Instant createdDate;
    /**
     * 最后修改者
     */
    private Integer lastModifiedBy;
    /**
     * 最后修改时间
     */
    private Instant lastModifiedDate;

}
