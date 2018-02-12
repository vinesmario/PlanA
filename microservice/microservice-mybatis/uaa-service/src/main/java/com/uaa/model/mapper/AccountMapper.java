package com.uaa.model.mapper;

import com.common.model.mapper.CrudMapper;
import com.uaa.model.po.Account;
import com.uaa.model.po.AccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper extends CrudMapper<Account, Long, AccountExample> {

	List<Account> selectByExample(AccountExample example);

	Account selectByPrimaryKey(Long primaryKey);

	void deleteByPrimaryKey(Long primaryKey);

	void deleteByExample(AccountExample example);

	/**
	 * xml中需要添加  useGeneratedKeys="true" keyProperty="id"
	 *
	 * @param entity
	 */
	void insert(Account entity);

	/**
	 * xml中需要添加 useGeneratedKeys="true" keyProperty="id"
	 *
	 * @param entity
	 */
	void insertSelective(Account entity);

	void updateByPrimaryKey(Account entity);

	void updateByPrimaryKeySelective(Account entity);

	void updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

	void updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

}
