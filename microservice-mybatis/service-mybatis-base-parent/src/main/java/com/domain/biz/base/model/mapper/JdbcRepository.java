package com.domain.biz.base.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface JdbcRepository<T, PK extends Serializable, EXAMPLE>
		extends PagingAndSortingRepository<T, PK>, QueryByExampleExecutor<T> {

	List<T> selectByExample(EXAMPLE example);

	T selectByPrimaryKey(PK primaryKey);

	void deleteByPrimaryKey(PK primaryKey);

	void deleteByExample(EXAMPLE example);

	/**
	 * xml中需要添加  useGeneratedKeys="true" keyProperty="id"
	 *
	 * @param entity
	 */
	void insert(T entity);

	/**
	 * xml中需要添加 useGeneratedKeys="true" keyProperty="id"
	 *
	 * @param entity
	 */
	void insertSelective(T entity);

	void updateByPrimaryKey(T entity);

	void updateByPrimaryKeySelective(T entity);

	void updateByExample(@Param("record") T record, @Param("example") EXAMPLE example);

	void updateByExampleSelective(@Param("record") T record, @Param("example") EXAMPLE example);
}
