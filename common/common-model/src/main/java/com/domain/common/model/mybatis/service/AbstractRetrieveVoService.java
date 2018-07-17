package com.domain.common.model.mybatis.service;

import com.domain.common.model.mybatis.dto.query.QueryDto;
import com.domain.common.model.mybatis.mapper.Example;
import com.domain.common.model.mybatis.mapper.RetrieveVoMapper;
import com.domain.common.model.mybatis.vo.RetrieveVo;
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
		PK extends Serializable,
		MAPPER extends RetrieveVoMapper<VO, PK>,
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

	public PageInfo<VO> findPage(QDTO queryDto, String orderByClause) {
		// 超过最大pageNum数，返回空。
		PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize(),true,false,false);
		Example example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		List<VO> list = mapper.selectByExample(example);
		return new PageInfo<>(list);
	}

	public List<VO> findList(QDTO queryDto) {
		return findList(queryDto, null);
	}

	public List<VO> findList(QDTO queryDto, String orderByClause) {
		Example example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		return mapper.selectByExample(example);
	}

	public VO selectByPrimaryKey(PK primaryKey) {
		return mapper.selectByPrimaryKey(primaryKey);
	}

	public abstract Example fromQueryDto2Example(QDTO queryDto);
}
