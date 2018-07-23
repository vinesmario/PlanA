package com.domain.common.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Base abstract class for entities which will
 * Create new records
 * Retrieve existing records
 * Update existing records
 * Delete existing records.
 */
@Accessors(chain = true)
@Data
public class CrudEntity {

	/**
	 * ID，主键
	 */
	private Integer id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 删除标识
	 */
	private Byte delFlag;
	/**
	 * 创建者
	 */
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	private LocalDateTime createdDate;
	/**
	 * 最后修改者
	 */
	private Integer lastModifiedBy;
	/**
	 * 最后修改时间
	 */
	private LocalDateTime lastModifiedDate;
}
