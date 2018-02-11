package com.model.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.dto.RetrieveDto;
import com.model.dto.RetrieveQueryDto;
import com.model.mapper.RetrieveMapper;
import com.model.mapstruct.RetrieveMapStruct;
import com.model.vo.RetrieveVo;
import com.model.vo.RetrieveVoExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractRetrieveServiceImpl<VO extends RetrieveVo,
        PK extends Serializable, EXAMPLE extends RetrieveVoExample,
        DTO extends RetrieveDto, QDTO extends RetrieveQueryDto> {

    @Autowired
    RetrieveMapper<VO, PK, EXAMPLE> mapper;

    @Autowired
    RetrieveMapStruct<VO, DTO> mapStruct;

    public PageInfo<DTO> findPage(Integer pageNum, Integer pageSize, String orderByClause, QDTO queryDto) {
        PageHelper.startPage(pageNum, pageSize);
        EXAMPLE example = fromQueryDto2Example(queryDto);
        example.setOrderByClause(orderByClause);

        List<VO> list = mapper.selectByExample(example);
        PageInfo<DTO> page = new PageInfo<>();
        BeanUtils.copyProperties(new PageInfo<>(list), page);
        page.setList(mapStruct.fromVos2Dtos(list));
        return page;
    }

    public List<DTO> findList(QDTO queryDto) {
        return findList(null, queryDto);
    }

    public List<DTO> findList(String orderByClause, QDTO queryDto) {
        EXAMPLE example = fromQueryDto2Example(queryDto);
        example.setOrderByClause(orderByClause);

        List<VO> list = mapper.selectByExample(example);
        return mapStruct.fromVos2Dtos(list);
    }

    public DTO selectByPrimaryKey(PK primaryKey) {
        return mapStruct.fromVo2Dto(mapper.selectByPrimaryKey(primaryKey));
    }

    public abstract EXAMPLE fromQueryDto2Example(QDTO queryDto);
}
