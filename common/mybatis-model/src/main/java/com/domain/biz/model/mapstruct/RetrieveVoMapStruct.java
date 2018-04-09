package com.domain.biz.model.mapstruct;

import com.domain.biz.model.dto.CrudDto;
import com.domain.biz.model.vo.RetrieveVo;

import java.util.List;

public interface RetrieveVoMapStruct<VO extends RetrieveVo, DTO extends CrudDto> {

	DTO fromVo2Dto(VO vo);

	List<DTO> fromVos2Dtos(List<VO> vos);

}
