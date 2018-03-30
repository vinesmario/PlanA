package com.domain.biz.uaa.po;

import com.domain.biz.model.po.TreeCrudEntity;
import lombok.Data;

import java.util.List;

/**
 * 部门、组织架构。
 * 不进行独立核算
 * 企业经营分部存在上下级关系
 */
@Data
public class Department extends TreeCrudEntity<Department> {
	/**
	 * 简称
	 */
	private String shortName;
	/**
	 * 座机
	 */
	private String telephone;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 简介
	 */
	private String profile;
	/**
	 * 租户ID
	 */
	private String tenantId;
	/**
	 * 主管职位ID
	 */
	private Integer chiefPositionId;
	/**
	 * 主管人员ID
	 */
	private Integer chiefUserId;
	/**
	 * 主管人员账号ID
	 */
	private Integer chiefAccountId;
	/**
	 * 省级区域ID
	 */
	private Integer provinceId;
	/**
	 * 地级区域ID，省辖市
	 */
	private Integer cityId;
	/**
	 * 县级区域ID，市辖区
	 */
	private Integer distinctId;
	/**
	 * 乡级区域ID，街道
	 */
	private Integer streetId;
	/**
	 * 乡级区域地址，街道
	 */
	private String streetAddress;
	/**
	 * 村级及以下详细地址，社区
	 */
	private String communityAddress;
	/**
	 * 地图服务提供商
	 */
	private Integer mapProvider;
	/**
	 * 经度
	 */
	private Double longitude;
	/**
	 * 纬度
	 */
	private Double latitude;
	/**
	 * 职位列表
	 */
	List<Position> positionList;

}
