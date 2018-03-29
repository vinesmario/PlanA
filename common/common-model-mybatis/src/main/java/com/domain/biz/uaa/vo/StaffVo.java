package com.domain.biz.uaa.vo;

import com.domain.biz.model.vo.TreeRetrieveVo;
import com.domain.biz.uaa.po.Account;
import com.domain.biz.uaa.po.Organ;
import com.domain.biz.uaa.po.Struct;
import com.domain.biz.uaa.po.User;
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
