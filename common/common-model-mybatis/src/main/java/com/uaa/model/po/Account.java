package com.uaa.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:18:56
 */
@Data
public class Account extends CrudEntity {

	//@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 证件号
	 */
	private String identityCardNumber;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 企鹅号
	 */
	private String qq;
	/**
	 * 微信号唯一标识
	 */
	private String wechatUnionId;
	/**
	 * 支付宝唯一标识
	 */
	private String alipayUserId;


}
