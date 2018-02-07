package com.common.model.po.uaa;

import com.common.model.po.assist.Attachment;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * 企业机构等签约合同
 */
@Data
public class OrganContract {

    /**
     * 生效日期
     */
    private LocalDate availabilityDate;
    /**
     * 到期日
     */
    private LocalDate expiryDate;
    /**
     * 有效时期
     */
    private String effectivePeriod;
    /**
     * 附件列表ID
     */
    private List<Attachment> attachmentId;
}
