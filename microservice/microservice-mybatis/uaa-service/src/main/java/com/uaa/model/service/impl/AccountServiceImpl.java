package com.uaa.model.service.impl;


import com.common.model.service.AbstractCrudServiceImpl;
import com.common.uaa.dto.AccountDto;
import com.common.uaa.dto.AccountQueryDto;
import com.common.uaa.po.Account;
import com.common.uaa.po.AccountExample;
import com.common.utils.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Service("accountServiceImpl")
public class AccountServiceImpl extends AbstractCrudServiceImpl<Account, Long, AccountExample,
        AccountDto, AccountQueryDto> {

    @Override
    public AccountExample fromQueryDto2Example(AccountQueryDto queryDto) {
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();

        if (null != queryDto) {
            if (null != queryDto.getId() && queryDto.getId().compareTo(0L) > 0) {
                criteria.andIdEqualTo(queryDto.getId());
            }
            if (StringUtils.isNotBlank(queryDto.getName())) {
//                criteria.and
            }
        }
        return example;
    }
}
