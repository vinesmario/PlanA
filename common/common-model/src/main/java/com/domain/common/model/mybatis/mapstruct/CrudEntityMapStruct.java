package com.domain.common.model.mybatis.mapstruct;


import com.domain.common.model.mybatis.dto.CrudDto;
import com.domain.common.model.mybatis.entity.CrudEntity;

import java.util.List;

public interface CrudEntityMapStruct<T extends CrudEntity, DTO extends CrudDto> {

	DTO fromEntity2Dto(T entity);

	T fromDto2Entity(DTO dto);

	List<DTO> fromEntities2Dtos(List<T> entities);

	List<T> fromDtos2Entities(List<DTO> dtos);
}
