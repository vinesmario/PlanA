<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.dto;

import com.common.model.vo.RetrieveVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class ${className}Vo extends RetrieveVo {

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
            <#if column.simpleJavaType == 'LocalDateTime'>
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
            <#elseif column.simpleJavaType == 'LocalDate'>
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
            <#elseif column.simpleJavaType == 'LocalTime'>
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
            <#else>
            </#if>
    private ${column.simpleJavaType} ${column.columnNameLower};
        </#if>
    </#list>

}
