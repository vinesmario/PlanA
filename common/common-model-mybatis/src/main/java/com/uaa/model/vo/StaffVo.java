package com.uaa.model.vo;

import com.common.model.vo.TreeRetrieveVo;
import com.uaa.model.po.Account;
import com.uaa.model.po.Organ;
import com.uaa.model.po.Struct;
import com.uaa.model.po.User;
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
