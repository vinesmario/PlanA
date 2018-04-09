<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.mapstruct;

import com.domain.biz.model.mapstruct.RetrieveVoMapStruct;
import com.domain.biz.${basepackage}.dto.${className}Dto;
import com.domain.biz.${basepackage}.vo.${className}Vo;
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
public interface ${className}VoMapStruct extends RetrieveVoMapStruct<${className}Vo, ${className}Dto> {

}
