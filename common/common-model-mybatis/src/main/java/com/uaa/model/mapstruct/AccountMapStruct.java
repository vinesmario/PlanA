package com.uaa.model.mapstruct;

import com.common.model.mapstruct.CrudMapStruct;
import com.uaa.model.dto.AccountDto;
import com.uaa.model.po.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapStruct extends CrudMapStruct<Account, AccountDto> {

}
