package com.common.model.mapper;

import com.common.model.po.CrudEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

public interface CrudMapper<T extends CrudEntity, PK extends Serializable, EXAMPLE> {

	Integer countByExample(EXAMPLE example);

	List<T> selectByExample(EXAMPLE example);

	T selectByPrimaryKey(PK primaryKey);

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

	void deleteByPrimaryKey(PK primaryKey);

	void deleteByExample(EXAMPLE example);

	void updateByPrimaryKey(T entity);

	void updateByPrimaryKeySelective(T entity);

	void updateByExample(@Param("record") T record, @Param("example") EXAMPLE example);

	void updateByExampleSelective(@Param("record") T record, @Param("example") EXAMPLE example);

}
