<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.mapper;

import com.common.model.mapper.CrudMapper;
import com.${basepackage}.model.po.${className};
import com.${basepackage}.model.po.${className}Example;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
public interface ${className}Mapper extends CrudMapper<${className}, Integer, ${className}Example> {

}
