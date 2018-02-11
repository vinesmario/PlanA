package com.model.mapstruct.uaa;

import com.model.dto.CrudDto;
import com.model.mapstruct.CrudMapStruct;
import com.model.po.CrudEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapStruct<T extends CrudEntity, DTO extends CrudDto> extends CrudMapStruct {

}
