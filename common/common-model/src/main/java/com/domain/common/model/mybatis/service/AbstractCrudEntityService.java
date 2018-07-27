package com.domain.common.model.mybatis.service;

import com.domain.common.model.dto.query.QueryDto;
import com.domain.common.model.entity.CrudEntity;
import com.domain.common.model.mybatis.mapper.CrudEntityMapper;
import com.domain.common.model.mybatis.mapper.CrudExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Data
@Service
public abstract class AbstractCrudEntityService<T extends CrudEntity<PK>, PK extends Serializable,
		MAPPER extends CrudEntityMapper<T, PK>> {

	@Autowired
	MAPPER mapper;

	public Integer countByExample(QueryDto queryDto) {
		CrudExample example = fromQueryDto2Example(queryDto);
		return mapper.countByExample(example);
	}

	public PageInfo<T> findPage(QueryDto queryDto, Pageable pageable) {
		// 超过最大pageNum数，返回空。
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), true, false, false);
		CrudExample example = fromQueryDto2Example(queryDto);

		if (null != pageable.getSort()) {
			List<String> orderByClauseList = Lists.newArrayList();
			Iterator<Sort.Order> it = pageable.getSort().iterator();
			while (it.hasNext()) {
				Sort.Order order = it.next();
				if (order.getDirection().isAscending()) {
					orderByClauseList.add(order.getProperty().toLowerCase() + " asc");
				} else {
					orderByClauseList.add(order.getProperty().toLowerCase() + " desc");
				}
			}
			example.setOrderByClause(StringUtils.join(orderByClauseList.toArray(), ","));
		}

		List<T> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<T> findList(QueryDto queryDto) {
		return findList(queryDto, null);
	}

	public List<T> findList(QueryDto queryDto, Sort sort) {
		CrudExample example = fromQueryDto2Example(queryDto);

		if (null != sort) {
			List<String> orderByClauseList = Lists.newArrayList();
			Iterator<Sort.Order> it = sort.iterator();
			while (it.hasNext()) {
				Sort.Order order = it.next();
				if (order.getDirection().isAscending()) {
					orderByClauseList.add(order.getProperty().toLowerCase() + " asc");
				} else {
					orderByClauseList.add(order.getProperty().toLowerCase() + " desc");
				}
			}
			example.setOrderByClause(StringUtils.join(orderByClauseList.toArray(), ","));
		}

		return mapper.selectByExample(example);
	}

	public T selectByPrimaryKey(PK primaryKey) {
		return mapper.selectByPrimaryKey(primaryKey);
	}

	public void insert(T entity) {
		entity.setCreatedDate(LocalDateTime.now())
				.setLastModifiedDate(LocalDateTime.now());
		mapper.insert(entity);
	}

	public void insertSelective(T entity) {
		entity.setCreatedDate(LocalDateTime.now())
				.setLastModifiedDate(LocalDateTime.now());
		mapper.insertSelective(entity);
	}

	public void deleteByPrimaryKey(PK primaryKey) {
		mapper.deleteByPrimaryKey(primaryKey);
	}

	public void deleteByExample(QueryDto queryDto) {
		CrudExample example = fromQueryDto2Example(queryDto);
		mapper.deleteByExample(example);
	}

	public void updateByPrimaryKey(T entity) {
		entity.setLastModifiedDate(LocalDateTime.now());
		mapper.updateByPrimaryKey(entity);
	}

	public void updateByPrimaryKeySelective(T entity) {
		entity.setLastModifiedDate(LocalDateTime.now());
		mapper.updateByPrimaryKeySelective(entity);
	}

	public void updateByExample(T entity, QueryDto queryDto) {
		CrudExample example = fromQueryDto2Example(queryDto);
		entity.setLastModifiedDate(LocalDateTime.now());
		mapper.updateByExample(entity, example);
	}

	public void updateByExampleSelective(T entity, QueryDto queryDto) {
		CrudExample example = fromQueryDto2Example(queryDto);
		entity.setLastModifiedDate(LocalDateTime.now());
		mapper.updateByExampleSelective(entity, example);
	}

	public abstract CrudExample fromQueryDto2Example(QueryDto queryDto);

}
