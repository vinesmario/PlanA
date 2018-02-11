package com.model.mapper;

import com.common.model.vo.RetrieveVoExample;
import com.common.model.vo.RetrieveVo;
import com.model.vo.RetrieveVo;
import com.model.vo.RetrieveVoExample;

import java.io.Serializable;
import java.util.List;

public interface RetrieveMapper<VO extends RetrieveVo, PK extends Serializable, EXAMPLE extends RetrieveVoExample> {

    List<VO> selectByExample(EXAMPLE example);

    VO selectByPrimaryKey(PK primaryKey);

}
