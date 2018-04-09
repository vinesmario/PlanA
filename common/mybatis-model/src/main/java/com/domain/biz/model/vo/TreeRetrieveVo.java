package com.domain.biz.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class TreeRetrieveVo<T extends RetrieveVo> extends RetrieveVo {

    private Integer parentId;

    private String parentIds;

    private Integer sort;

    private T parent;

    private List<T> chldren;

}
