package com.domain.biz.uaa.service;


import com.domain.biz.model.service.AbstractCrudService;
import com.domain.biz.uaa.dto.AccountQueryDto;
import com.domain.biz.uaa.mapper.AccountMapper;
import com.domain.biz.uaa.po.Account;
import com.domain.biz.uaa.po.AccountExample;
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
