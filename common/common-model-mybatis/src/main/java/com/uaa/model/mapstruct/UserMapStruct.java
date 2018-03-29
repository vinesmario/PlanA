package com.uaa.model.mapstruct;

import com.common.model.mapstruct.CrudMapStruct;
import com.uaa.model.dto.UserDto;
import com.uaa.model.po.User;
import org.mapstruct.Mapper;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 15:24:20
 */
@Mapper(componentModel = "spring")
public interface UserMapStruct extends CrudMapStruct<User, UserDto> {

}
