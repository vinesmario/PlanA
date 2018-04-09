package com.domain.biz.uaa.mapstruct;

import com.domain.biz.model.mapstruct.CrudEntityMapStruct;
import com.domain.biz.uaa.dto.AccountDto;
import com.domain.biz.uaa.po.Account;
import org.mapstruct.Mapper;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:18:56
 */
@Mapper(componentModel = "spring")
public interface AccountMapStruct extends CrudEntityMapStruct<Account, AccountDto> {

}
