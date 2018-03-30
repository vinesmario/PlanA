package com.domain.biz.uaa.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 租户财务配置（经济活动相关）
 * TODO 拆分到金融服务
 */
@Data
public class TenantFinance extends CrudEntity {
	/**
	 * 三证（工商营业执照、组织机构代码证和税务登记证）合一
	 * 统一社会信用代码
	 */
	private String creditCode;
	/**
	 * 开户银行名称
	 */
	private String bankName;
	/**
	 * 开户银行网点名称
	 */
	private String bankBranchName;
	/**
	 * 开户名称
	 */
	private String bankAccountName;
	/**
	 * 开户账号
	 */
	private String bankAccountNo;



}
