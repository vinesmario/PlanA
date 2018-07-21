package com.domain.common.model.vo;


import com.domain.common.model.entity.CrudEntity;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Base class for value object which can retrieve only.
 */
@Accessors(chain = true)
@Builder
@Data
public class CrudVo extends CrudEntity {

}
