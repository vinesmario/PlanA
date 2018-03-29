package com.domain.biz.model.dto;

import lombok.Data;

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

}
