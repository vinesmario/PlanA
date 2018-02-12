package com.common.uaa.po;

import com.common.model.po.TreeCrudEntity;
import lombok.Data;

import java.util.List;

/**
 * 部门、组织架构。
 * 不进行独立核算
 * 母子公司相同职能部门存在上下级关系
 */
@Data
public class Struct extends TreeCrudEntity<Struct> {
	/**
	 * 负责人
	 */
	private String representative;
	/**
	 * 座机
	 */
	private String telephone;
	/**
	 * 传真
	 */
	private String fax;
	/**
	 * 电子邮箱，用来创建超级管理员
	 */
	private String email;
	/**
	 * 联系人
	 */
	private String linkman;
	/**
	 * 联系人手机
	 */
	private String linkmanMobile;
	/**
	 * 网站主页
	 */
	private String homePage;
	/**
	 * 简介
	 */
	private String profile;
	/**
	 * 省级区域ID，可能为空
	 */
	private Integer provinceId;
	/**
	 * 地级区域ID，可能为空
	 */
	private Integer cityId;
	/**
	 * 县级区域ID，可能为空
	 */
	private Integer distinctId;
	/**
	 * 乡级区域ID，可能为空
	 */
	private Integer streetId;
	/**
	 * 乡级区域地址
	 */
	private String streetAddress;
	/**
	 * 村级及以下详细地址
	 */
	private String villageAddress;
	/**
	 * 企业ID
	 */
	private String organId;
	/**
	 * 职工列表
	 */
	List<Staff> staffList;
}
