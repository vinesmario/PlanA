package com.domain.biz.uaa.service;


import com.domain.biz.uaa.dto.AccountQueryDto;
import com.domain.biz.uaa.mapper.AccountMapper;
import com.domain.biz.uaa.po.Account;
import com.domain.common.model.dto.query.QueryDto;
import com.domain.common.model.mybatis.mapper.CrudExample;
import com.domain.common.model.mybatis.service.AbstractCrudEntityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Service
public class AccountService extends AbstractCrudEntityService<Account, Integer, AccountMapper> {

	public CrudExample fromQueryDto2Example(QueryDto queryDto) {
		AccountQueryDto accountQueryDto = (AccountQueryDto) queryDto;

		CrudExample example = new CrudExample();
		CrudExample.Criteria criteria = example.createCriteria();

		if (null != queryDto) {
			if (null != accountQueryDto.getId() && accountQueryDto.getId().compareTo(0) > 0) {
				criteria.addCriterion("id =", accountQueryDto.getId(), "id");
//				criteria.andIdEqualTo(accountQueryDto.getId());
			}
			if (StringUtils.isNotBlank(accountQueryDto.getName())) {
//                criteria.and
			}
		}
		return example;
	}
}
