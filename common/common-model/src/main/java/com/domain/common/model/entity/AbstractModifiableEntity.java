package com.domain.common.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by
 * and created,last modified by date.
 */
@Accessors(chain = true)
@Data
public abstract class AbstractModifiableEntity extends AbstractAddibleEntity {

	/**
	 * 最后修改者
	 */
	private Integer lastModifiedBy;
	/**
	 * 最后修改时间
	 */
	private LocalDateTime lastModifiedDate;


}
