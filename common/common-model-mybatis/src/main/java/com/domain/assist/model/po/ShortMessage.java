package com.domain.assist.model.po;

import com.domain.common.mybatis.annotation.AuditEnable;
import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

/**
 * 短信，待发送
 */
@Data
@AuditEnable(table = "assist_short_message")
public class ShortMessage extends CrudEntity {

    /**
     * 接收手机号ShortMessageTemplate
     */
    private String mobile;
    /**
     * 模板ID
     */
    private Integer templateId;
    /**
     * 参数内容
     */
    private String params;


}
