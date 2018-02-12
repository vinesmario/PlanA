package com.common.model.po.uaa;

import com.common.model.po.CrudEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * 用户
 */
@Data
public class User extends CrudEntity {

    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期 yyyy-MM-dd
     */
    private LocalDate birthDate;
    /**
     * 生日 MM-dd
     */
    private String birthday;
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
     * 企鹅号
     */
    private String qq;
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
    /**
     * 省级区域ID，可能为空
     */
    private Integer provinceId;
    /**
     * 地级区域ID，可能为空
     */
    private Integer cityId;
    /**
     * 县级区域ID，可能为空
     */
    private Integer distinctId;
    /**
     * 乡级区域ID，可能为空
     */
    private Integer streetId;
    /**
     * 乡级区域地址
     */
    private String streetAddress;
    /**
     * 村级及以下详细地址
     */
    private String villageAddress;
    /**
     * 账号ID
     */
    private String accountId;
    /**
     * 角色列表
     */
    private List<Role> roleList;
    // user role module
    /**
     * 模块列表
     */
    private List<Module> moduleList;
    // user module password token
    /**
     * 职工列表 一对多
     */
    private List<Staff> staffList;
    /**
     * 部门列表
     */
    private List<Struct> structList;
    /**
     * 企业列表
     */
    private List<Organ> companyList;

}
