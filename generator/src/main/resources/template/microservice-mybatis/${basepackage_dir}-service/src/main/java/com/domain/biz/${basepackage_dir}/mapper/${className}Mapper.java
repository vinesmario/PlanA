<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.mapper;

import com.domain.biz.model.mapper.CrudMapper;
import com.domain.biz.${basepackage}.po.${className};
import com.domain.biz.${basepackage}.po.${className}Example;

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
