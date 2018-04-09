package com.domain.biz.model.mapper;

import com.domain.biz.model.vo.RetrieveVo;
import com.domain.biz.model.vo.RetrieveVoExample;

import java.io.Serializable;
import java.util.List;

public interface RetrieveVoMapper<VO extends RetrieveVo,
        PK extends Serializable, EXAMPLE extends RetrieveVoExample> {

    List<VO> selectByExample(EXAMPLE example);

    VO selectByPrimaryKey(PK primaryKey);

}
