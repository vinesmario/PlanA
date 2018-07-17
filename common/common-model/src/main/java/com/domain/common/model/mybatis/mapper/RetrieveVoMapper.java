package com.domain.common.model.mybatis.mapper;


import com.domain.common.model.mybatis.vo.RetrieveVo;

import java.io.Serializable;
import java.util.List;

public interface RetrieveVoMapper<VO extends RetrieveVo,
		PK extends Serializable> {

	Integer countByExample(Example example);

	List<VO> selectByExample(Example example);

	VO selectByPrimaryKey(PK primaryKey);

}
