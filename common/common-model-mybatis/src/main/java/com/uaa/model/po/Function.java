package com.uaa.model.po;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 菜单、功能，数据的CRUD操作
 */
@Data
public class Function extends TreeCrudEntity<Function> {

	private String httpMethod;//
	private String uri;    // 链接，不包括http://host:port部分
	private String target;   // 目标
	private String icon;    // 图标
	private String permission; // 权限标识

}
