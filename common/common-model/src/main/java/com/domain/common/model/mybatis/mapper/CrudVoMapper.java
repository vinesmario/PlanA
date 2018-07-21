package com.domain.common.model.mybatis.mapper;


import com.domain.common.model.vo.CrudVo;

import java.io.Serializable;
import java.util.List;

public interface CrudVoMapper<VO extends CrudVo,
		PK extends Serializable> {

	Integer countByExample(Example example);

	List<VO> selectByExample(Example example);

	VO selectByPrimaryKey(PK primaryKey);

	void insert(VO entity);

	void deleteByPrimaryKey(PK primaryKey);

	void updateByPrimaryKey(VO entity);
}
