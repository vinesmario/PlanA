package com.uaa.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 租户运营配置（信息技术服务相关）
 * TODO 拆分到运营服务
 */
@Data
public class TenantOperation extends CrudEntity {
	/**
	 * 简称
	 */
	private String shortName;
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
	 * 乡级区域地址（XX省XX市XX区XX街道）
	 */
	private String streetAddress;
	/**
	 * 村级及以下详细地址（XX社区XX大厦XX栋）
	 */
	private String communityAddress;
	/**
	 * 地图服务提供商
	 */
	private String mapServiceProvider;
	/**
	 * 经度
	 */
	private Double longitude;
	/**
	 * 纬度
	 */
	private Double latitude;
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
