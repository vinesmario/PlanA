<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.po;

import com.common.model.po.CrudEntity;
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
public class ${className} extends CrudEntity {

	//@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
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
