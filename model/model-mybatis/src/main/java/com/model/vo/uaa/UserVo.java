package com.model.vo.uaa;

import com.model.po.uaa.Account;
import com.model.vo.RetrieveVo;
import lombok.Data;

/**
 * 用户及其关联
 */
@Data
public class UserVo extends RetrieveVo {

    private Account account;

}
