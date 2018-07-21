package com.domain.common.model.mapstruct;

import com.domain.common.model.dto.CrudDto;
import com.domain.common.model.vo.CrudVo;

import java.util.List;

public interface CrudVoMapStruct<VO extends CrudVo, DTO extends CrudDto> {

	DTO fromVo2Dto(VO vo);

	List<DTO> fromVos2Dtos(List<VO> vos);

}
