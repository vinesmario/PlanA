package com.common.model.service;

import com.common.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractReadService<VO extends ReadVo,
        PK extends Serializable, EXAMPLE extends ReadVoExample,
        DTO extends ReadDto, QDTO extends QueryReadDto> {

    @Autowired
    ReadMapper<VO, PK, EXAMPLE> mapper;

    @Autowired
    ReadMapStruct<VO, DTO> mapStruct;

    public PageInfo<DTO> findPage(Integer pageNum, Integer pageSize, String orderByClause, QDTO queryDto) {
        PageHelper.startPage(pageNum, pageSize);

        ReadVoExample example = new ReadVoExample();
        if (StringUtils.isNotBlank(orderByClause)) {
            example.setOrderByClause(orderByClause);
        }

        if (null != queryDto) {

        }
        ReadVoExample.Criteria criteria = example.createCriteria();

        List<VO> list = mapper.selectByExample(example);
        PageInfo<DTO> page = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(list), page);
        page.setList(mapStruct.fromVos2Dtos(list));
        return page;
    }

    public List<DTO> findList(QDTO queryDto) {
        ReadVoExample example = new ReadVoExample();
        ReadVoExample.Criteria criteria = example.createCriteria();

        List<VO> list = mapper.selectByExample(example);
        return mapStruct.fromVos2Dtos(list);
    }

    public DTO selectByPrimaryKey(PK primaryKey) {
        return mapStruct.fromVo2Dto(mapper.selectByPrimaryKey(primaryKey));
    }
}
