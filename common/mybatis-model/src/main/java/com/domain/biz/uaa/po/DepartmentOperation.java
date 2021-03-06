package com.domain.biz.uaa.po;

import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 部门运营配置（信息技术服务相关）
 * 原则上无部门财务配置
 * TODO 拆分到运营服务
 */
@Data
public class DepartmentOperation extends CrudEntity {
	/**
	 * 简称
	 */
	private String shortName;
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
