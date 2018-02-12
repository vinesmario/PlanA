package com.common.model.service;

import com.common.model.dto.CrudDto;
import com.common.model.dto.CrudQueryDto;
import com.common.model.dto.CrudDto;
import com.common.model.dto.CrudQueryDto;
import com.common.model.po.CrudEntity;
import com.common.model.po.CrudEntityExample;
import com.common.model.po.TreeCrudEntity;

import java.io.Serializable;
import java.util.List;

public abstract class TreeCrudServiceImpl<T extends TreeCrudEntity<T>,
        PK extends Serializable, EXAMPLE extends CrudEntityExample,
        DTO extends CrudDto, QDTO extends CrudQueryDto> extends AbstractCrudServiceImpl {

    public DTO findChild() {
        return null;
    }

    public List<DTO> findChildren() {
        return null;
    }

}
