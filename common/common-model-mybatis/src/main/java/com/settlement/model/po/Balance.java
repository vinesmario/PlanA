package com.settlement.model.po;

import com.common.mybatis.annotation.AuditEnable;
import com.common.model.po.CrudEntity;
import lombok.Data;

@Data
@AuditEnable(table = "balance_a")
public class Balance extends CrudEntity {

}
