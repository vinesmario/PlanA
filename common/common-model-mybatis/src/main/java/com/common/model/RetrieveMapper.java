package com.common.model;

import java.io.Serializable;
import java.util.List;

public interface RetrieveMapper<VO extends RetrieveVo, PK extends Serializable, EXAMPLE extends RetrieveVoExample> {

    List<VO> selectByExample(EXAMPLE example);

    VO selectByPrimaryKey(PK primaryKey);

}
