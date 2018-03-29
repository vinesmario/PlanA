<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.mapstruct;

import com.domain.biz.model.mapstruct.CrudMapStruct;
import com.domain.biz.${basepackage}.dto.${className}Dto;
import com.domain.biz.${basepackage}.po.${className};
import org.mapstruct.Mapper;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Mapper(componentModel = "spring")
public interface ${className}MapStruct extends CrudMapStruct<${className}, ${className}Dto> {

}
