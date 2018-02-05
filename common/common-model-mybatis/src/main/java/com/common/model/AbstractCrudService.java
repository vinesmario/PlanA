package com.common.model;

import com.common.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractCrudService<T extends CrudEntity,
        PK extends Serializable, EXAMPLE extends CrudEntityExample,
        DTO extends CrudDto, QDTO extends QueryCrudDto> {

    @Autowired
    CrudMapper<T, PK, EXAMPLE> mapper;

    @Autowired
    CrudMapStruct<T, DTO> mapStruct;

    public PageInfo<DTO> findPage(Integer pageNum, Integer pageSize, String orderByClause, QDTO queryDto) {
        PageHelper.startPage(pageNum, pageSize);

        CrudEntityExample example = new CrudEntityExample();
        if (StringUtils.isNotBlank(orderByClause)) {
            example.setOrderByClause(orderByClause);
        }

        CrudEntityExample.Criteria criteria = example.createCriteria();
        if (null != queryDto) {

        }

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
        CrudEntityExample example = new CrudEntityExample();
        CrudEntityExample.Criteria criteria = example.createCriteria();
        if (null != queryDto) {

        }
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

    public void updateByExample(QDTO queryDto) {
        CrudEntityExample example = new CrudEntityExample();
        mapper.updateByExample(example);
    }

    public void deleteByPrimaryKey(PK primaryKey) {
        mapper.deleteByPrimaryKey(primaryKey);
    }

    public void deleteByExample(QDTO queryDto) {
        mapper.deleteByExample(example);
    }

}
