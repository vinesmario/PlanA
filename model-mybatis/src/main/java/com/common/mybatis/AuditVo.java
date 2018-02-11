package com.common.mybatis;

import com.common.model.po.CrudEntity;
import lombok.Data;
import org.apache.ibatis.mapping.SqlCommandType;

import java.time.Instant;

@Data
public class AuditVo<T extends CrudEntity> {

    /**
     * 主键（64位UUID）
     */
    private String auditId;
    /**
     * 审计操作(insert,update,delete)
     */
    private SqlCommandType auditTransactionType;
    /**
     * 审计时间
     */
    private Instant auditDate;
    /**
     * 审计 session id
     */
    private String auditSessionId;

    T crudEntity;

    Class<T> type;

}
