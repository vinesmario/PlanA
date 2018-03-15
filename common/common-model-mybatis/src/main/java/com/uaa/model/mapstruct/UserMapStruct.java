package com.uaa.model.mapstruct;

import com.common.model.mapstruct.CrudMapStruct;
import com.uaa.model.dto.UserDto;
import com.uaa.model.po.User;
import org.mapstruct.Mapper;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:58:02
 */
@Mapper(componentModel = "spring")
public interface UserMapStruct extends CrudMapStruct<User, UserDto> {

}
