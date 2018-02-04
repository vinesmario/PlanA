package com.common.model;

import java.io.Serializable;
import java.util.List;

public interface ReadMapper<VO extends ReadVo, PK extends Serializable, EXAMPLE extends ReadVoExample> {

    List<VO> selectByExample(EXAMPLE example);

    VO selectByPrimaryKey(PK primaryKey);

}
