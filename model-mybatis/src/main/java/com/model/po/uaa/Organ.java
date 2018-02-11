package com.model.po.uaa;

import com.common.model.po.TreeCrudEntity;
import com.model.po.TreeCrudEntity;
import lombok.Data;

import java.util.List;

/**
 * 企业（民间组织、非盈利机构......）等社团法人，
 * 原则上是会计独立核算单位
 * 原则上通过控制、合营、联营或法定管理制度进行上下级关联
 * 原则上每个企业至少存在执行机关
 */
@Data
public class Organ extends TreeCrudEntity<Organ> {
    /**
     * 负责人
     */
    private String representative;
    /**
     * 座机
     */
    private String telephone;
    /**
     * 传真
     */
    private String fax;
    /**
     * 电子邮箱，用来创建超级管理员
     */
    private String email;
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系人手机
     */
    private String linkmanMobile;
    /**
     * 网站主页
     */
    private String homePage;
    /**
     * 收藏夹图标
     */
    private String favicon;
    /**
     * logo
     */
    private String logo;
    /**
     * 地址栏域名
     */
    private String domain;
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
     * 部门列表
     */
    private List<Struct> structList;
    /**
     * 职工列表
     */
    private List<Staff> staffList;

}
