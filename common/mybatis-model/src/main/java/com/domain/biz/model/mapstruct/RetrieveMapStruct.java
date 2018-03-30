package com.domain.biz.model.mapstruct;

import com.domain.biz.model.dto.RetrieveDto;
import com.domain.biz.model.vo.RetrieveVo;

import java.util.List;

public interface RetrieveMapStruct<VO extends RetrieveVo, DTO extends RetrieveDto> {

    DTO fromVo2Dto(VO vo);

    List<DTO> fromVos2Dtos(List<VO> vos);

}
