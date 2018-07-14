package com.domain.common.model.mybatis.entity;

import lombok.Data;

import java.time.Instant;

/**
 * Base abstract class for entities which will hold definitions for created, last modified by
 * and created,last modified by date.
 */
@Data
public abstract class AbstractModifiableEntity extends AbstractAddibleEntity {

	/**
	 * 最后修改者
	 */
	private Integer lastModifiedBy;
	/**
	 * 最后修改时间
	 */
	private Instant lastModifiedDate = Instant.now();


}
