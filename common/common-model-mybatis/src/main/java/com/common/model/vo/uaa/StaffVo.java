package com.common.model.vo.uaa;

import com.common.model.po.uaa.Account;
import com.common.model.po.uaa.Organ;
import com.common.model.po.uaa.Struct;
import com.common.model.po.uaa.User;
import com.common.model.vo.TreeRetrieveVo;
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
