package com.common.model;

import java.util.List;

public interface RetrieveMapStruct<VO extends RetrieveVo, DTO extends RetrieveDto> {

    DTO fromVo2Dto(VO vo);

    List<DTO> fromVos2Dtos(List<VO> vos);

}
