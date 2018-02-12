package com.common.model.po;

import lombok.Data;

import java.util.List;

@Data
public class TreeCrudEntity<T extends CrudEntity> extends CrudEntity {

    private Long parentId;

    private String parentIds;

    private Integer sort;

    private T parent;

    private List<T> chldren;

}
