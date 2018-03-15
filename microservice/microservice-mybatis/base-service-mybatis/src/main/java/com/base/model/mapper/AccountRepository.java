package com.base.model.mapper;

import com.uaa.model.po.Account;
import com.uaa.model.po.AccountExample;

public interface AccountRepository extends JdbcRepository<Account, Integer, AccountExample> {


}
