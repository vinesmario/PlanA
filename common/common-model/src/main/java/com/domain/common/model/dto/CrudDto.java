package com.domain.common.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Accessors(chain = true)
@Builder
@Data
public class CrudDto implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * 删除标识 0-否；1-是
	 */
	private Byte delFlag = 0;
	/**
	 * 创建者
	 */
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime createdDate;
	/**
	 * 最后修改者
	 */
	private Integer lastModifiedBy;
	/**
	 * 最后修改时间
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private LocalDateTime lastModifiedDates;
}
