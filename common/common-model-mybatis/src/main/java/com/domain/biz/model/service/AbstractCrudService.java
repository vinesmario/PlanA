package com.domain.biz.model.service;

import com.domain.biz.model.dto.CrudQueryDto;
import com.domain.biz.model.mapper.CrudMapper;
import com.domain.biz.model.po.CrudEntity;
import com.domain.biz.model.po.CrudEntityExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class AbstractCrudService<T extends CrudEntity,
		PK extends Serializable, EXAMPLE extends CrudEntityExample,
		MAPPER extends CrudMapper<T, PK, EXAMPLE>,
		QDTO extends CrudQueryDto> {

	@Autowired
	MAPPER mapper;

	public PageInfo<T> findPage(Integer pageNum, Integer pageSize,
								String orderByClause, QDTO queryDto) {
		PageHelper.startPage(pageNum, pageSize);
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		List<T> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<T> findList(String orderByClause, QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		return mapper.selectByExample(example);
	}

	public T selectByPrimaryKey(PK primaryKey) {
		return mapper.selectByPrimaryKey(primaryKey);
	}

	public void insert(T entity) {
		mapper.insert(entity);
	}

	public void insertSelective(T entity) {
		mapper.insertSelective(entity);
	}

	public void deleteByPrimaryKey(PK primaryKey) {
		mapper.deleteByPrimaryKey(primaryKey);
	}

	public void deleteByExample(QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		mapper.deleteByExample(example);
	}

	public void updateByPrimaryKey(T entity) {
		mapper.updateByPrimaryKey(entity);
	}

	public void updateByPrimaryKeySelective(T entity) {
		mapper.updateByPrimaryKeySelective(entity);
	}

	public void updateByExample(T entity, QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		mapper.updateByExample(entity, example);
	}

	public void updateByExampleSelective(T entity, QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		mapper.updateByExampleSelective(entity, example);
	}

	public abstract EXAMPLE fromQueryDto2Example(QDTO queryDto);

}
