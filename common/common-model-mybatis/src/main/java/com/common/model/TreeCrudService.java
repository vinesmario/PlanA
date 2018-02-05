package com.common.model;

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
