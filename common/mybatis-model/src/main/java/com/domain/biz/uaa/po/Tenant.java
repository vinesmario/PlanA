package com.domain.biz.uaa.po;

import com.domain.biz.model.po.TreeCrudEntity;
import lombok.Data;

import java.util.List;

/**
 * 租户，这里指企业（民间组织、非盈利机构......）等社团法人，
 * 原则上是会计独立核算单位
 * 原则上通过控制、合营、联营或法定管理制度进行上下级关联
 * 原则上每个企业至少存在执行机关
 * 供应商、客户、企业本身
 */
@Data
public class Tenant extends TreeCrudEntity<Tenant> {
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
	 * 主管部门ID
	 */
	private Integer chiefDepartmentId;
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
	 * 部门列表
	 */
	private List<Department> departmentList;
	/**
	 * 职位列表
	 */
	private List<Position> positionList;

}
