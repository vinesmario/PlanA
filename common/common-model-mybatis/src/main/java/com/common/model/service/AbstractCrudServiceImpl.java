package com.common.model.service;

import com.common.model.dto.CrudDto;
import com.common.model.dto.CrudQueryDto;
import com.common.model.mapper.CrudMapper;
import com.common.model.mapstruct.CrudMapStruct;
import com.common.model.po.CrudEntity;
import com.common.model.po.CrudEntityExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class AbstractCrudServiceImpl<T extends CrudEntity,
		PK extends Serializable, EXAMPLE extends CrudEntityExample,
		MAPPER extends CrudMapper<T, PK, EXAMPLE>,
		DTO extends CrudDto, MAPSTRUCT extends CrudMapStruct<T, DTO>,
		QDTO extends CrudQueryDto> {

	@Autowired
	MAPPER mapper;

	@Autowired
	MAPSTRUCT mapStruct;

	public PageInfo<DTO> findPage(Integer pageNum, Integer pageSize, String orderByClause, QDTO queryDto) {
		PageHelper.startPage(pageNum, pageSize);
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);

		List<T> list = mapper.selectByExample(example);
		PageInfo<DTO> page = new PageInfo<>();
		BeanUtils.copyProperties(new PageInfo<>(list), page);
		page.setList(mapStruct.fromEntities2Dtos(list));
		return page;
	}

	public List<DTO> findList(QDTO queryDto) {
		return findList(null, queryDto);
	}

	public List<DTO> findList(String orderByClause, QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		example.setOrderByClause(orderByClause);
		List<T> list = mapper.selectByExample(example);
		return mapStruct.fromEntities2Dtos(list);
	}

	public DTO selectByPrimaryKey(PK primaryKey) {
		return mapStruct.fromEntity2Dto(mapper.selectByPrimaryKey(primaryKey));
	}

	public void insert(DTO dto) {
		T entity = mapStruct.fromDto2Entity(dto);
		mapper.insert(entity);
		dto.setId(entity.getId());
	}

	public void updateByPrimaryKey(DTO dto) {
		T entity = mapStruct.fromDto2Entity(dto);
		mapper.updateByPrimaryKey(mapStruct.fromDto2Entity(dto));
	}

	public void updateByExample(T entity, QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		mapper.updateByExample(entity, example);
	}

	public void deleteByPrimaryKey(PK primaryKey) {
		mapper.deleteByPrimaryKey(primaryKey);
	}

	public void deleteByExample(QDTO queryDto) {
		EXAMPLE example = fromQueryDto2Example(queryDto);
		mapper.deleteByExample(example);
	}

	public abstract EXAMPLE fromQueryDto2Example(QDTO queryDto);
}
