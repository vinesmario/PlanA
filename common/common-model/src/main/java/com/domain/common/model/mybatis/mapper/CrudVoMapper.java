package com.domain.common.model.mybatis.mapper;


import com.domain.common.model.vo.CrudVo;

import java.io.Serializable;
import java.util.List;

public interface CrudVoMapper<VO extends CrudVo<PK>, PK extends Serializable> {

	Integer countByExample(CrudExample example);

	List<VO> selectByExample(CrudExample example);

	VO selectByPrimaryKey(PK primaryKey);

}
