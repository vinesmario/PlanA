package com.domain.biz.model.service;

import com.domain.biz.model.dto.QueryDto;
import com.domain.biz.model.mapper.RetrieveVoMapper;
import com.domain.biz.model.vo.RetrieveVo;
import com.domain.biz.model.vo.RetrieveVoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class AbstractRetrieveVoService<VO extends RetrieveVo,
		PK extends Serializable, EXAMPLE extends RetrieveVoExample,
		MAPPER extends RetrieveVoMapper<VO, PK, EXAMPLE>,
		QDTO extends QueryDto> {

	@Autowired
	MAPPER mapper;

	public PageInfo<VO> findPage(Integer pageNum, Integer pageSize,
								 String orderByClause, QDTO queryDto) {
		PageHelper.startPage(pageNum, pageSize);
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		List<VO> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<VO> findList(QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		return mapper.selectByExample(example);
	}

	public VO selectByPrimaryKey(PK primaryKey) {
		return mapper.selectByPrimaryKey(primaryKey);
	}

	public abstract EXAMPLE fromQueryDto2Example(QDTO queryDto);
}
