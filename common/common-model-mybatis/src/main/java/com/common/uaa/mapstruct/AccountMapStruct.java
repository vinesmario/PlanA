package com.common.uaa.mapstruct;

import com.common.model.mapstruct.CrudMapStruct;
import com.common.uaa.dto.AccountDto;
import com.common.uaa.po.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapStruct extends CrudMapStruct<Account, AccountDto> {

}
