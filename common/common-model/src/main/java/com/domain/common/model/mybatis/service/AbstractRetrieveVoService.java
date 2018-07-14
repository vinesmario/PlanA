package com.domain.common.model.mybatis.service;

import com.cwgj.common.model.dto.query.QueryDto;
import com.cwgj.common.model.mapper.RetrieveVoMapper;
import com.cwgj.common.model.vo.RetrieveVo;
import com.cwgj.common.model.vo.example.RetrieveVoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Data
@Service
public abstract class AbstractRetrieveVoService<VO extends RetrieveVo,
		PK extends Serializable, EXAMPLE extends RetrieveVoExample,
		MAPPER extends RetrieveVoMapper<VO, PK, EXAMPLE>,
		QDTO extends QueryDto> {

	@Autowired
	MAPPER mapper;

	public Integer countByExample(QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		return mapper.countByExample(example);
	}

	public PageInfo<VO> findPage(QDTO queryDto) {
		return findPage(queryDto, null);
	}

	public PageInfo<VO> findPage(QDTO queryDto, String orderByClause) {
		// 超过最大pageNum数，返回空。
		PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize(),true,false,false);
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		List<VO> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<VO> findList(QDTO queryDto) {
		return findList(queryDto, null);
	}

	public List<VO> findList(QDTO queryDto, String orderByClause) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		return mapper.selectByExample(example);
	}

	public VO selectByPrimaryKey(PK primaryKey) {
		return mapper.selectByPrimaryKey(primaryKey);
	}

	public abstract EXAMPLE fromQueryDto2Example(QDTO queryDto);
}
