package com.uaa.model.mapstruct;

import com.common.model.mapstruct.CrudMapStruct;
import com.uaa.model.dto.AccountDto;
import com.uaa.model.po.Account;
import org.mapstruct.Mapper;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:18:56
 */
@Mapper(componentModel = "spring")
public interface AccountMapStruct extends CrudMapStruct<Account, AccountDto> {

}
