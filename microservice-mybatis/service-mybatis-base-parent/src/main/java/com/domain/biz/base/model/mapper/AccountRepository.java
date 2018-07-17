package com.domain.biz.base.model.mapper;

import com.domain.biz.uaa.po.Account;
import com.domain.biz.uaa.po.AccountExample;

public interface AccountRepository extends JdbcRepository<Account, Integer, AccountExample> {


}
