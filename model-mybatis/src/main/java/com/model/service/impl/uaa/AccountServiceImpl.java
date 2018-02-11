package com.model.service.impl.uaa;


import com.common.utils.StringUtils;
import com.model.dto.uaa.AccountDto;
import com.model.dto.uaa.AccountQueryDto;
import com.model.po.uaa.Account;
import com.model.po.uaa.AccountExample;
import com.model.service.AbstractCrudServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Service("accountServiceImpl")
public class AccountServiceImpl extends AbstractCrudServiceImpl<Account, Integer, AccountExample,
        AccountDto, AccountQueryDto> {

    @Override
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
