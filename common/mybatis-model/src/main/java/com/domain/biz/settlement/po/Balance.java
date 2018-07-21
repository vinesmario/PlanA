package com.domain.biz.settlement.po;

import com.domain.common.model.mybatis.annotation.AuditEnable;
import com.domain.biz.model.po.CrudEntity;
import lombok.Data;

@Data
@AuditEnable(table = "balance_a")
public class Balance extends CrudEntity {

}
