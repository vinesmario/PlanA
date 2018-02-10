package com.common.model.mapstruct;

import com.common.model.dto.CrudDto;
import com.common.model.po.CrudEntity;

import java.util.List;

public interface CrudMapStruct<T extends CrudEntity, DTO extends CrudDto> {

    DTO fromEntity2Dto(T entity);

    T fromDto2Entity(DTO dto);

    List<DTO> fromEntities2Dtos(List<T> entities);

    List<T> fromDtos2Entities(List<DTO> dtos);
}
