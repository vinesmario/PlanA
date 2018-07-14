package com.domain.common.model.mybatis.service;

import com.cwgj.common.model.dto.query.QueryDto;
import com.cwgj.common.model.entity.CrudEntity;
import com.cwgj.common.model.entity.example.CrudEntityExample;
import com.cwgj.common.model.mapper.CrudEntityMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Data
@Service
public abstract class AbstractCrudEntityService<T extends CrudEntity,
		PK extends Serializable, EXAMPLE extends CrudEntityExample,
		MAPPER extends CrudEntityMapper<T, PK, EXAMPLE>,
		QDTO extends QueryDto> {

	@Autowired
	MAPPER mapper;

	public Integer countByExample(QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		return mapper.countByExample(example);
	}

	public PageInfo<T> findPage(QDTO queryDto) {
		return findPage(queryDto, null);
	}

	public PageInfo<T> findPage(QDTO queryDto, String orderByClause) {
		// 超过最大pageNum数，返回空。
		PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize(),true,false,false);
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		List<T> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<T> findList(QDTO queryDto) {
		return findList(queryDto, null);
	}

	public List<T> findList(QDTO queryDto, String orderByClause) {
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
