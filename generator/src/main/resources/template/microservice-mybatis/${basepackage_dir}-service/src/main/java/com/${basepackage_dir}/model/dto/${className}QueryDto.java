<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.dto;

import com.common.model.dto.CrudQueryDto;
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
public class ${className}QueryDto extends CrudQueryDto {

    //@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    <#list table.columns as column>
        <#if column.remarks?exists && column.remarks != '' && column.remarks != 'null'>
    /**
     * ${column.remarks}
     */
        </#if>
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#list>
}
