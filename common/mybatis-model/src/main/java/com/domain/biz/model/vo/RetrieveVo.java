package com.domain.biz.model.vo;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

import java.time.Instant;

/**
 * Base class for value object which can retrieve only.
 */
@Data
public class RetrieveVo extends CrudEntity {

	/**
	 * 创建者
	 */
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	private Instant createdDate;
	/**
	 * 最后修改者
	 */
	private Integer lastModifiedBy;
	/**
	 * 最后修改时间
	 */
	private Instant lastModifiedDate;

}
