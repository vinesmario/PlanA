package com.common.model.vo.uaa;

import com.common.model.ReadVo;
import com.common.model.po.uaa.Account;
import lombok.Data;

/**
 * 用户及其关联
 */
@Data
public class UserVo extends ReadVo {

    private Account account;

}
