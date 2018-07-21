package com.domain.common.model.mybatis.mapper;

import com.domain.common.model.mybatis.entity.CrudEntity;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface CrudEntityMapper<T extends CrudEntity, PK extends Serializable> {

	Integer countByExample(Example example);

	List<T> selectByExample(Example example);

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

	void deleteByExample(Example example);

	void updateByPrimaryKey(T entity);

	void updateByPrimaryKeySelective(T entity);

	void updateByExample(@Param("record") T record, @Param("example") Example example);

	void updateByExampleSelective(@Param("record") T record, @Param("example") Example example);

}