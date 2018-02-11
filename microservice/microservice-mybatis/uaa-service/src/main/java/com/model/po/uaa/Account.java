package com.model.po.uaa;


import com.model.po.CrudEntity;
import lombok.Data;

/**
 * 账号
 */
@Data
public class Account extends CrudEntity {

    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String identityCardNumber;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * QQ
     */
    private String qq;

    private String wechat_union_id;

    private String alipay_user_id;

    // TODO QQ授权 微博授权

}
