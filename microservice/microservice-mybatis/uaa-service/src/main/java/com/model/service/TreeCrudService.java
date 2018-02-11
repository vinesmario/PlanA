package com.model.service;

import com.model.dto.CrudDto;
import com.model.dto.CrudQueryDto;
import com.model.po.CrudEntity;
import com.model.po.CrudEntityExample;

import java.io.Serializable;
import java.util.List;

public class TreeCrudService<T extends CrudEntity,
        PK extends Serializable, EXAMPLE extends CrudEntityExample,
        DTO extends CrudDto, QDTO extends CrudQueryDto> extends AbstractCrudServiceImpl {

    public DTO findChild() {
        return null;
    }

    public List<DTO> findChildren() {
        return null;
    }

}
