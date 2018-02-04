package com.common.model;

import lombok.Data;

@Data
public class ReadVo extends AbstractAuditingVo {

    private String id;

    private String name;

    private String memo;

    private String delFlag;

}
