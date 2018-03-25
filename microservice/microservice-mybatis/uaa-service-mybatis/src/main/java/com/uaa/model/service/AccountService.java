package com.uaa.model.service;


import com.common.model.service.AbstractCrudService;
import com.uaa.model.dto.AccountQueryDto;
import com.uaa.model.mapper.AccountMapper;
import com.uaa.model.po.Account;
import com.uaa.model.po.AccountExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Service
public class AccountService extends AbstractCrudService<Account, Integer, AccountExample, AccountMapper,
		AccountQueryDto> {

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
