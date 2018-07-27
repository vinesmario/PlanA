package com.domain.common.model.vo;


import com.domain.common.model.entity.CrudEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Base class for value object which can retrieve only.
 */
@Accessors(chain = true)
@Data
public class CrudVo<PK extends Serializable> extends CrudEntity {

}
