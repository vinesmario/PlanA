<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.mapstruct;

import com.common.model.mapstruct.CrudMapStruct;
import com.${basepackage}.model.dto.${className}Dto;
import com.${basepackage}.model.po.${className};
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
