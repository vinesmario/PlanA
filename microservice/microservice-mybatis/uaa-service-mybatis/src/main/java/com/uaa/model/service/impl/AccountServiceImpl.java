package com.uaa.model.service.impl;


import com.common.model.service.AbstractCrudServiceImpl;
import com.common.utils.StringUtils;
import com.uaa.model.dto.AccountDto;
import com.uaa.model.dto.AccountQueryDto;
import com.uaa.model.mapper.AccountMapper;
import com.uaa.model.mapstruct.AccountMapStruct;
import com.uaa.model.po.Account;
import com.uaa.model.po.AccountExample;
import org.springframework.stereotype.Service;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Service("accountServiceImpl")
public class AccountServiceImpl extends AbstractCrudServiceImpl<Account, Integer, AccountExample, AccountMapper,
		AccountDto, AccountMapStruct, AccountQueryDto> {

	public AccountExample fromQueryDto2Example(AccountQueryDto queryDto) {
		AccountExample example = new AccountExample();
		AccountExample.Criteria criteria = example.createCriteria();

		if (null != queryDto) {
			if (null != queryDto.getId() && queryDto.getId().compareTo(0) > 0) {
				criteria.andIdEqualTo(queryDto.getId());
			}
			if (StringUtils.isNotBlank(queryDto.getName())) {
//                criteria.and
			}
		}
		return example;
	}
}
