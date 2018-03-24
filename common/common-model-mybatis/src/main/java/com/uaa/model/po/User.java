package com.uaa.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * 用户，自然人信息
 *
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:58:02
 */
@Data
public class User extends CrudEntity {

	//@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 出生日期
	 */
	private LocalDate birthDate;
	/**
	 * 生日
	 */
	private String birthday;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 简介
	 */
	private String profile;
//	/**
//	 * 省级区域ID
//	 */
//	private Integer provinceId;
//	/**
//	 * 地级区域ID
//	 */
//	private Integer cityId;
//	/**
//	 * 县级区域ID
//	 */
//	private Integer distinctId;
//	/**
//	 * 乡级区域ID
//	 */
//	private Integer streetId;
//	/**
//	 * 乡级区域地址
//	 */
//	private String streetAddress;
//	/**
//	 * 村级及以下详细地址
//	 */
//	private String villageAddress;


	private Integer accountId;


}
