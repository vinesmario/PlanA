package com.uaa.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 租户财务配置（经济活动相关）
 */
@Data
public class TenantFinance extends CrudEntity {
	/**
	 * 网站主页
	 */
	private String homePage;
	/**
	 * 收藏夹图标
	 */
	private String favicon;
	/**
	 * logo
	 */
	private String logo;
	/**
	 * 地址栏域名
	 */
	private String domain;


}
