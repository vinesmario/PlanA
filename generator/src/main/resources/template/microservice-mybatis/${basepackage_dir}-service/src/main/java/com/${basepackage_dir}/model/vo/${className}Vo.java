<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.dto;

import com.common.model.vo.RetrieveVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Data
public class ${className}Dto extends RetrieveVo {

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    <#list table.columns as column>
        <#if column.columnNameLower != 'id'
            && column.columnNameLower != 'name'
            && column.columnNameLower != 'createdBy'
            && column.columnNameLower != 'createdDate'
            && column.columnNameLower != 'lastModifiedBy'
            && column.columnNameLower != 'lastModifiedDate'
            && column.columnNameLower != 'memo'
            && column.columnNameLower != 'delFlag'>
    /**
     * ${column.remarks}
     */
    private ${column.simpleJavaType} ${column.columnNameLower};
        </#if>
    </#list>

}
