package com.common.model;

import lombok.Data;

@Data
public class RetrieveVo extends AbstractReadOnlyVo {

    private String id;

    private String name;

    private String memo;

    private String delFlag;

}
