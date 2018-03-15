package com.uaa.model.po;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 职位
 * 两个职工的用户角色ID相同，可以传递部门的上下级关系。
 * 两个对应的用户角色ID不同，视为平级关系，可以创建关系表。
 * 每个部门可以虚拟一个超级管理员用户，以企业邮箱为用户名
 */
@Data
public class Position extends TreeCrudEntity<Position> {

	/**
	 * 租户ID，不能为空
	 */
	private Integer tenantId;
	/**
	 * 部门ID，不能为空
	 */
	private Integer departmentId;
	/**
	 * 用户ID，可能为空
	 */
	private Integer userId;
	/**
	 * 账户ID，可能为空
	 */
	private Integer accountId;


}
