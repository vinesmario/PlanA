package com.uaa.model.vo;

import com.common.model.vo.RetrieveVo;
import com.uaa.model.po.Account;
import lombok.Data;

/**
 * 用户及其关联
 */
@Data
public class UserVo extends RetrieveVo {

    private Account account;

}
