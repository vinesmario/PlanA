package com.common.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

@Data
public class CrudDto {

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
	 * 创建者（用户ID）
	 */
	private String createdBy;
	/**
	 * 创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Instant createdDate;
	/**
	 * 最后修改者（用户ID）
	 */
	private String lastModifiedBy;
	/**
	 * 最后修改时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Instant lastModifiedDate;
}
