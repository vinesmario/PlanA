package com.domain.common.model.mybatis.mapper;

import com.cwgj.common.model.vo.RetrieveVo;
import com.cwgj.common.model.vo.example.RetrieveVoExample;

import java.io.Serializable;
import java.util.List;

public interface RetrieveVoMapper<VO extends RetrieveVo,
		PK extends Serializable, EXAMPLE extends RetrieveVoExample> {

	Integer countByExample(EXAMPLE example);

	List<VO> selectByExample(EXAMPLE example);

	VO selectByPrimaryKey(PK primaryKey);

}
