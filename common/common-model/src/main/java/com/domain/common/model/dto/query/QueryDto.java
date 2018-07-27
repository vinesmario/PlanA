package com.domain.common.model.dto.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Data
public class QueryDto {

	/**
	 * ID，主键
	 */
	private Integer id;
	/**
	 * ID为空，true表示查询记录为空
	 */
	private boolean idIsNull = false;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 默认需要以delFlag过滤
	 */
	private boolean delFlagIsNull = false;
	/**
	 * 删除标识 0-否；1-是  delFlagIsNull=false才有效
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
	private LocalDateTime lastModifiedDate;

}
