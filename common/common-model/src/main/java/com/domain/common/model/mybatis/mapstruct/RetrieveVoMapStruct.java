package com.domain.common.model.mybatis.mapstruct;

import com.domain.common.model.mybatis.dto.CrudDto;
import com.domain.common.model.mybatis.vo.RetrieveVo;

import java.util.List;

public interface RetrieveVoMapStruct<VO extends RetrieveVo, DTO extends CrudDto> {

	DTO fromVo2Dto(VO vo);

	List<DTO> fromVos2Dtos(List<VO> vos);

}
