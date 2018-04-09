<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.mapper;

import com.domain.biz.model.mapper.RetrieveVoMapper;
import com.domain.biz.${basepackage}.vo.${className}Vo;
import com.domain.biz.${basepackage}.vo.${className}VoExample;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
public interface ${className}VoMapper extends RetrieveVoMapper<${className}Vo, Integer, ${className}VoExample> {

}
