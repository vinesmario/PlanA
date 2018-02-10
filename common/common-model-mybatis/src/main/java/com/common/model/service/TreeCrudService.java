package com.common.model.service;

import com.common.model.dto.CrudDto;
import com.common.model.dto.QueryCrudDto;
import com.common.model.po.CrudEntity;
import com.common.model.po.CrudEntityExample;
import com.common.model.service.AbstractCrudService;

import java.io.Serializable;
import java.util.List;

public class TreeCrudService<T extends CrudEntity,
        PK extends Serializable, EXAMPLE extends CrudEntityExample,
        DTO extends CrudDto, QDTO extends QueryCrudDto> extends AbstractCrudService {

    public DTO findChild() {
        return null;
    }

    public List<DTO> findChildren() {
        return null;
    }

}
