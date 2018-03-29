package com.domain.biz.uaa.mapstruct;

import com.domain.biz.model.mapstruct.CrudMapStruct;
import com.domain.biz.uaa.dto.UserDto;
import com.domain.biz.uaa.po.User;
import org.mapstruct.Mapper;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 18:12:40
 */
@Mapper(componentModel = "spring")
public interface UserMapStruct extends CrudMapStruct<User, UserDto> {

}
