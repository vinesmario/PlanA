package com.uaa.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 部门运营配置（信息技术服务相关）
 * 原则上无部门财务配置
 */
@Data
public class DepartmentOperation extends CrudEntity {
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
