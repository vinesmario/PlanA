package com.uaa.model.dto;

import com.common.model.dto.CrudQueryDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:58:02
 */
@Data
public class UserQueryDto extends CrudQueryDto {

    //@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String identityCardNumber;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 出生日期
     */
    private LocalDate birthDate;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 手机号
     */
    private String mobile;
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
     * 省级区域ID
     */
    private Integer provinceId;
    /**
     * 地级区域ID
     */
    private Integer cityId;
    /**
     * 县级区域ID
     */
    private Integer distinctId;
    /**
     * 乡级区域ID
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


    private Integer accountId;

}
