package com.domain.biz.risk.po;

import com.domain.assist.model.po.Attachment;
import com.domain.biz.model.po.CrudEntity;
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
	private List<Attachment> attachmentList;
}
