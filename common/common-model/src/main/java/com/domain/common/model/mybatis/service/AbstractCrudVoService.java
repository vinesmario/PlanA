package com.domain.common.model.mybatis.service;

import com.domain.common.model.dto.query.QueryDto;
import com.domain.common.model.mybatis.mapper.CrudVoMapper;
import com.domain.common.model.mybatis.mapper.Example;
import com.domain.common.model.vo.CrudVo;
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
import java.util.Iterator;
import java.util.List;

@Data
@Service
public abstract class AbstractCrudVoService<VO extends CrudVo,
		PK extends Serializable,
		MAPPER extends CrudVoMapper<VO, PK>,
		QDTO extends QueryDto> {

	@Autowired
	MAPPER mapper;

	public Integer countByExample(QDTO queryDto) {
		Example example = fromQueryDto2Example(queryDto);
		return mapper.countByExample(example);
	}

	public PageInfo<VO> findPage(QDTO queryDto) {
		return findPage(queryDto, null);
	}

	public PageInfo<VO> findPage(QDTO queryDto, Pageable pageable) {
		// 超过最大pageNum数，返回空。
		PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), true, false, false);
		Example example = fromQueryDto2Example(queryDto);

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
		List<VO> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<VO> findList(QDTO queryDto) {
		return findList(queryDto, null);
	}

	public List<VO> findList(QDTO queryDto, Sort sort) {
		Example example = fromQueryDto2Example(queryDto);

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

	public VO selectByPrimaryKey(PK primaryKey) {
		return mapper.selectByPrimaryKey(primaryKey);
	}

	public abstract Example fromQueryDto2Example(QDTO queryDto);
}
