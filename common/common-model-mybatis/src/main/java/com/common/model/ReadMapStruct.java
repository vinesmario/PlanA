package com.common.model;

import java.util.List;

public interface ReadMapStruct<VO extends ReadVo, DTO extends ReadDto> {

    DTO fromVo2Dto(VO vo);

    List<DTO> fromVos2Dtos(List<VO> vos);

}
