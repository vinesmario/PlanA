package com.common.risk.po;

import com.common.assist.po.Attachment;
import com.common.model.po.CrudEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * 签约合同
 */
@Data
public class Contract extends CrudEntity {

	/**
	 * 生效日期
	 */
	private LocalDate availabilityDate;
	/**
	 * 到期日
	 */
	private LocalDate expiryDate;
	/**
	 * 有效时期
	 */
	private String effectivePeriod;
	/**
	 * 附件列表ID
	 */
	private List<Attachment> attachmentId;
}
