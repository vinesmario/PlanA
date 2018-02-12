package com.common.uaa.vo;

import com.common.model.vo.TreeRetrieveVo;
import com.common.uaa.po.Account;
import com.common.uaa.po.Organ;
import com.common.uaa.po.Struct;
import com.common.uaa.po.User;
import lombok.Data;

/**
 * 职工及其关联
 */
@Data
public class StaffVo extends TreeRetrieveVo<StaffVo> {

	/**
	 * 账户，可能为空
	 */
	private Account account;
	/**
	 * 用户，可能为空
	 */
	private User user;
	/**
	 * 企业
	 */
	private Organ company;
	/**
	 * 部门
	 */
	private Struct dept;

}
