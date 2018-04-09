package com.domain.biz.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

@Data
public class CrudQueryDto {

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
    /**
     * 创建者
     */
    private Integer createdBy;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant createdDate;
    /**
     * 最后修改者
     */
    private Integer lastModifiedBy;
    /**
     * 最后修改时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant lastModifiedDate;

}
