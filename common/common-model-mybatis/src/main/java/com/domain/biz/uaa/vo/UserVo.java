package com.domain.biz.uaa.vo;

import com.domain.biz.model.vo.RetrieveVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 18:12:40
 */
@Data
public class UserVo extends RetrieveVo {

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
    private Integer districtId;
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
    /**
     * 
     */
    private Integer accountId;

}
